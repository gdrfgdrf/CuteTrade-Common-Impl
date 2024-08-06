package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.log.LogType
import io.github.gdrfgdrf.cutetrade.extension.logError
import io.github.gdrfgdrf.cutetrade.extension.logInfo

object LoggerFunctionsImpl : CommonFunctions.LoggerFunctions {
    override fun log(logType: LogType, message: String, vararg args: Any) {
        when(logType) {
            LogType.INFO -> message.logInfo(*args)
            LogType.ERROR -> message.logError()
        }
    }

    override fun error(message: String, throwable: Throwable) {
        message.logError(throwable)
    }
}