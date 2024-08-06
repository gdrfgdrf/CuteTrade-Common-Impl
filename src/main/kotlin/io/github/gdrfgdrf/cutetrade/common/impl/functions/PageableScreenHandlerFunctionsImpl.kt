package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.trade.screen.handler.ScreenHandlerAgent
import io.github.gdrfgdrf.cutetrade.page.PageableScreenHandler

object PageableScreenHandlerFunctionsImpl : CommonFunctions.PageableScreenHandlerFunctions {
    override fun setOnItemClick(screenHandlerAgent: ScreenHandlerAgent, onItemClick: (Int) -> Unit) {
        val pageableScreenHandler = screenHandlerAgent.raw as PageableScreenHandler
        pageableScreenHandler.onItemClick = onItemClick
    }
}