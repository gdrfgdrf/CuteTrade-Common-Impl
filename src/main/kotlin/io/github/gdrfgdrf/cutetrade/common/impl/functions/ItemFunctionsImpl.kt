package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.impl.ItemProxyImpl
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemProxy
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import java.util.concurrent.ConcurrentHashMap

object ItemFunctionsImpl : CommonFunctions.ItemFunctions {
    private val CACHE = ConcurrentHashMap<String, ItemConvertible>()

    init {
        CACHE["LIME_WOOL"] = Items.LIME_WOOL
        CACHE["RED_STAINED_GLASS_PANE"] = Items.RED_STAINED_GLASS_PANE
        CACHE["WHITE_STAINED_GLASS_PANE"] = Items.WHITE_STAINED_GLASS_PANE
        CACHE["REDSTONE_BLOCK"] = Items.REDSTONE_BLOCK
        CACHE["GOLD_BLOCK"] = Items.GOLD_BLOCK
    }

    override fun get(fieldName: String): ItemProxy {
        if (CACHE.containsKey(fieldName)) {
            val item = CACHE[fieldName]
            return ItemProxyImpl.create(item!!)
        }

        val itemsClass = Items::class.java
        val field = itemsClass.getDeclaredField(fieldName)
        val item = field.get(null) as ItemConvertible
        return ItemProxyImpl.create(item)
    }
}