package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.proxy.ItemProxy
import net.minecraft.item.ItemConvertible

class ItemProxyImpl private constructor(item: Any) : ItemProxy(item) {


    companion object {
        fun create(item: ItemConvertible): ItemProxy = ItemProxyImpl(item)
    }

}