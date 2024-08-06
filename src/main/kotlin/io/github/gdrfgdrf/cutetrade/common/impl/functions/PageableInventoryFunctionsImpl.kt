package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.page.Pageable
import io.github.gdrfgdrf.cutetrade.page.PageableInventory

object PageableInventoryFunctionsImpl : CommonFunctions.PageableInventoryFunctions {
    override fun setPageable(inventory: Any, pageable: Pageable) {
        (inventory as PageableInventory).pageable = pageable
    }
}