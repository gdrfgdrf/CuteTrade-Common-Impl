package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.screen.factory.TradeScreenHandlerFactory

object TradeScreenHandlerFactoryGetterImpl : CommonFunctions.TradeScreenHandlerFactoryGetter {
    override fun create(title: String): Any {
        return TradeScreenHandlerFactory(title)
    }
}