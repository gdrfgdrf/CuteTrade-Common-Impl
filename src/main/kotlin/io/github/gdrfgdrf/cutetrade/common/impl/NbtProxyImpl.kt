package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.proxy.NbtProxy
import net.minecraft.nbt.NbtCompound

class NbtProxyImpl private constructor(nbt: Any): NbtProxy(nbt) {
    override fun asString(): String = get().asString()

    fun get(): NbtCompound = nbt as NbtCompound

    companion object {
        fun create(nbtCompound: NbtCompound): NbtProxy = NbtProxyImpl(nbtCompound)
    }
}