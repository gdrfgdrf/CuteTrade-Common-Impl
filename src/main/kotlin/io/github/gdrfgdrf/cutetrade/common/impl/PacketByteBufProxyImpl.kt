package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.extension.getProxyFactory
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.NbtProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.PacketByteBufProxy
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.PacketByteBuf

class PacketByteBufProxyImpl private constructor(packetByteBuf: PacketByteBuf): PacketByteBufProxy(packetByteBuf) {
    override fun readString(): String = get().readString()

    override fun readInt(): Int = get().readInt()

    override fun readItemStack(): ItemStackProxy {
        val factory = getProxyFactory()

        val nbtCompound = get().readNbt()
        val nbtProxy = factory.newNbt()
        nbtProxy.nbt = nbtCompound!!

        return factory.createItemStackProxyFromNbt(nbtProxy)
    }

    override fun writeString(str: String) {
        get().writeString(str)
    }

    override fun writeInt(i: Int) {
        get().writeInt(i)
    }

    override fun writeItemStack(itemStackProxy: ItemStackProxy) {
        val factory = getProxyFactory()
        val nbtProxy = factory.newNbt()

        itemStackProxy.writeNbt(nbtProxy)

        get().writeNbt(nbtProxy.nbt as NbtCompound)
    }

    override fun writeNbt(nbtProxy: NbtProxy) {
        val nbtCompound = nbtProxy.nbt as NbtCompound
        get().writeNbt(nbtCompound)
    }

    fun get(): PacketByteBuf = packetByteBuf as PacketByteBuf

    companion object {
        fun create(packetByteBuf: PacketByteBuf): PacketByteBufProxy =
            io.github.gdrfgdrf.cutetrade.common.impl.PacketByteBufProxyImpl(packetByteBuf)
    }
}