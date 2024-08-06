package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.impl.ItemStackProxyImpl
import io.github.gdrfgdrf.cutetrade.common.impl.NbtProxyImpl
import io.github.gdrfgdrf.cutetrade.common.impl.PacketByteBufProxyImpl
import io.github.gdrfgdrf.cutetrade.common.impl.TextProxyImpl
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.NbtProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.PacketByteBufProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.TextProxy
import io.github.gdrfgdrf.cutetrade.extension.registryManager
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.StringNbtReader
import net.minecraft.network.PacketByteBuf
import net.minecraft.text.Text

object ProxyFactoryImpl : CommonFunctions.ProxyFactory {
    override fun createItemStackProxyFromNbt(nbtProxy: NbtProxy): ItemStackProxy {
        val itemStack = ItemStack.fromNbtOrEmpty(registryManager(), nbtProxy.nbt as NbtCompound)
        return ItemStackProxyImpl.create(itemStack)
    }

    override fun newNbt(): NbtProxy {
        return NbtProxyImpl.create(NbtCompound())
    }

    override fun parseNbt(string: String): NbtProxy {
        return NbtProxyImpl.create(StringNbtReader.parse(string))
    }

    override fun createTextProxy(string: String): TextProxy {
        return TextProxyImpl.create(Text.of(string))
    }

    override fun createPacketByteBufProxy(packetByteBuf: Any): PacketByteBufProxy {
        return PacketByteBufProxyImpl.create(packetByteBuf as PacketByteBuf)
    }
}