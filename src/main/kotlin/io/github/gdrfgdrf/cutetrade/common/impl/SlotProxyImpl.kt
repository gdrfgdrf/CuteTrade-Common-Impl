package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.SlotProxy
import net.minecraft.screen.slot.Slot

class SlotProxyImpl private constructor(slot: Any): SlotProxy(slot) {
    override fun hasStack(): Boolean = get().hasStack()

    override fun stack(): ItemStackProxy {
        return ItemStackProxyImpl.create(get().stack)
    }

    fun get(): Slot = slot as Slot

    companion object {
        fun create(slot: Slot): SlotProxy = SlotProxyImpl(slot)
    }
}