package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack

object InventoryFunctionsImpl : CommonFunctions.InventoryFunctions {
    override fun setStack(inventory: Any, index: Int, stack: ItemStackProxy) {
        val inventory1 = inventory as Inventory
        inventory1.setStack(index, stack.itemStack as ItemStack)
    }
}