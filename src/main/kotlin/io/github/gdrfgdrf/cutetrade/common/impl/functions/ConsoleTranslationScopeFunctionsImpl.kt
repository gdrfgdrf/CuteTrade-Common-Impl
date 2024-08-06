package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.CuteTrade
import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.enums.TranslationType
import io.github.gdrfgdrf.cutetrade.common.translation.TranslationAgent
import io.github.gdrfgdrf.cutetrade.common.translation.TranslationTextAgent
import io.github.gdrfgdrf.cutetrade.extension.logInfo
import io.github.gdrfgdrf.cutetranslationapi.text.CuteText
import io.github.gdrfgdrf.cutetranslationapi.text.CuteTranslation

object ConsoleTranslationScopeFunctionsImpl : CommonFunctions.ConsoleTranslationScopeFunctions {
    override fun send(translationAgent: TranslationAgent) {
        val cuteTranslation = translationAgent.cuteTranslation as CuteTranslation
        val text = cuteTranslation.build()
        text.string.logInfo()
    }

    override fun getTranslation(translationType: TranslationType, key: String): TranslationAgent {
        if (CuteTrade.TRANSLATION_PROVIDER == null) {
            throw IllegalStateException("Translation provider is not loaded normally")
        }

        val fullKey = translationType.rootKey + key
        val message = CuteTrade.TRANSLATION_PROVIDER!!.get(fullKey)
        val cuteTranslation = CuteTranslation.of(message)

        return TranslationAgent(cuteTranslation, null)
    }

    override fun getText(translationType: TranslationType, key: String): TranslationTextAgent {
        if (CuteTrade.TRANSLATION_PROVIDER == null) {
            throw IllegalStateException("Translation provider is not loaded normally")
        }

        val fullKey = translationType.rootKey + key
        val message = CuteTrade.TRANSLATION_PROVIDER!!.get(fullKey)
        val cuteText = CuteText.of(message)

        return TranslationTextAgent(cuteText)
    }
}