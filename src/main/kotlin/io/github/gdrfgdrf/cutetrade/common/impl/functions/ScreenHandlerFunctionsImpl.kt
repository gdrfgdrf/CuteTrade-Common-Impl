package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.impl.ItemStackProxyImpl
import io.github.gdrfgdrf.cutetrade.common.impl.SlotProxyImpl
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.SlotProxy
import io.github.gdrfgdrf.cutetrade.common.trade.screen.handler.ScreenHandlerAgent
import io.github.gdrfgdrf.cutetrade.page.PageableScreenHandler
import io.github.gdrfgdrf.cutetrade.screen.handler.TradeScreenHandler
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerListener

object ScreenHandlerFunctionsImpl : CommonFunctions.ScreenHandlerFunctions {
    override fun getInventory(screenHandlerAgent: ScreenHandlerAgent): Any? {
        val screenHandler = screenHandlerAgent.raw as ScreenHandler
        if (screenHandler is PageableScreenHandler) {
            return screenHandler.inventory!!
        }
        if (screenHandler is TradeScreenHandler) {
            return screenHandler.inventory
        }
        return null
    }

    override fun setStackInSlot(
        screenHandlerAgent: ScreenHandlerAgent,
        slot: Int,
        revision: Int,
        stack: ItemStackProxy,
    ) {
        val screenHandler = screenHandlerAgent.raw as ScreenHandler
        screenHandler.setStackInSlot(slot, revision, stack.itemStack as ItemStack)
    }

    override fun getSlot(screenHandlerAgent: ScreenHandlerAgent, slotId: Int): SlotProxy {
        val screenHandler = screenHandlerAgent.raw as ScreenHandler
        return SlotProxyImpl.create(screenHandler.getSlot(slotId))
    }

    override fun addListener(
        screenHandlerAgent: ScreenHandlerAgent,
        listener: (ScreenHandlerAgent, Int, ItemStackProxy) -> Unit,
    ) {
        val screenHandler = screenHandlerAgent.raw as ScreenHandler
        screenHandler.addListener(object : ScreenHandlerListener {
            override fun onSlotUpdate(handler: ScreenHandler, slotId: Int, stack: ItemStack) {
                listener(screenHandlerAgent, slotId, ItemStackProxyImpl.create(stack))
            }

            override fun onPropertyUpdate(handler: ScreenHandler?, property: Int, value: Int) {
            }
        })
    }

    override fun nextRevision(screenHandlerAgent: ScreenHandlerAgent): Int {
        val screenHandler = screenHandlerAgent.raw as ScreenHandler
        return screenHandler.nextRevision()
    }
}