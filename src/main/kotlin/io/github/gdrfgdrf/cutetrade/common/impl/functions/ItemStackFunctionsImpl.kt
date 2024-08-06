package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.impl.ItemStackProxyImpl
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemStack

object ItemStackFunctionsImpl : CommonFunctions.ItemStackFunctions {
    private val EMPTY = ItemStackProxyImpl.create(ItemStack.EMPTY)

    override fun create(itemProxy: ItemProxy): ItemStackProxy {
        val itemStack = ItemStack(itemProxy.item as ItemConvertible)
        return ItemStackProxyImpl.create(itemStack)
    }

    override fun getEmptyItemStack(): ItemStackProxy =
        EMPTY
}