package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.impl.functions.*
import io.github.gdrfgdrf.cutetrade.common.pool.CommonFunctionsPool
import io.github.gdrfgdrf.cutetrade.extension.logInfo

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
            InventoryFunctionsImpl,
            PageableInventoryFunctionsImpl
        )

        implements.forEach {
            "Register a function implementation ${it.javaClass.simpleName}".logInfo()
            CommonFunctionsPool.addFunctions(it)
        }
    }


}