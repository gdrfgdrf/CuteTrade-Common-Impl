package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.impl.ItemProxyImpl
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemProxy
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items

object ItemFunctionsImpl : CommonFunctions.ItemFunctions {
    override fun get(fieldName: String): ItemProxy {
        val itemsClass = Items::class.java
        val field = itemsClass.getDeclaredField(fieldName)
        val item = field.get(null) as ItemConvertible
        return ItemProxyImpl.create(item)
    }
}