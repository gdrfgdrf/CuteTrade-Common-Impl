package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.NbtProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.TextProxy
import io.github.gdrfgdrf.cutetrade.extension.registryManager
import io.github.gdrfgdrf.cutetrade.extension.setCustomName
import net.minecraft.item.ItemStack
import net.minecraft.text.Text

class ItemStackProxyImpl private constructor(itemStack: Any) : ItemStackProxy(itemStack) {
    private var name: TextProxy? = null
        get() {
            if (field == null) {
                field = TextProxyImpl.create(get().name)
            }
            return field
        }

    override fun name(): TextProxy = name!!

    override fun count(): Int = get().count

    override fun isEmpty(): Boolean = get().isEmpty

    override fun copy(): ItemStackProxy {
        val copied = get().copy()
        return create(copied)
    }

    override fun setCustomName(textProxy: TextProxy) = get().setCustomName(textProxy.text as Text)

    override fun writeNbt(nbtProxy: NbtProxy) {
        val nbtCompound = get().encode(registryManager())
        nbtProxy.nbt = nbtCompound
    }

    fun get(): ItemStack = itemStack as ItemStack

    companion object {
        fun create(itemStack: ItemStack): ItemStackProxy =
            ItemStackProxyImpl(itemStack)
    }
}