package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.impl.functions.*
import io.github.gdrfgdrf.cutetrade.common.pool.CommonFunctionsPool

object Functions {
    fun initialize() {
        val implements = arrayOf(
            ProxyFactoryImpl,
            MainFunctionsImpl,
            NetworkFunctionsImpl,
            LoggerFunctionsImpl,
            ItemStackFunctionsImpl,
            ItemFunctionsImpl,
            TranslationTextFunctionsImpl,
            TranslationFunctionsImpl,
            SoundGetterImpl,
            TradeScreenHandlerFactoryGetterImpl,
            PageableScreenHandlerFactoryGetterImpl,
            ScreenHandlerFunctionsImpl,
            PageableScreenHandlerFunctionsImpl,
            InventoryFunctionsImpl
        )

        implements.forEach(CommonFunctionsPool::addFunctions)


    }


}