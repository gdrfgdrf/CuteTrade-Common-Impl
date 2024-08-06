package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.impl.TextProxyImpl
import io.github.gdrfgdrf.cutetrade.common.proxy.TextProxy
import io.github.gdrfgdrf.cutetrade.common.translation.TranslationAgent
import io.github.gdrfgdrf.cutetrade.common.translation.TranslationTextAgent
import io.github.gdrfgdrf.cutetrade.extension.format
import io.github.gdrfgdrf.cutetranslationapi.text.CuteText
import io.github.gdrfgdrf.cutetranslationapi.text.CuteTranslation

object TranslationFunctionsImpl : CommonFunctions.TranslationFunctions {
    override fun get(translationAgent: TranslationAgent, index: Int): TranslationTextAgent {
        val cuteTranslation = translationAgent.cuteTranslation as CuteTranslation
        val cuteText = cuteTranslation.get(index)
        return TranslationTextAgent(cuteText)
    }

    override fun append(
        translationAgent: TranslationAgent,
        translationTextAgent: TranslationTextAgent,
    ): TranslationAgent {
        val cuteTranslation = translationAgent.cuteTranslation as CuteTranslation
        val cuteText = translationTextAgent.cuteText as CuteText
        cuteTranslation.append(cuteText)

        return translationAgent
    }

    override fun format(translationAgent: TranslationAgent, index: Int, vararg any: Any): TranslationAgent {
        val cuteTranslation = translationAgent.cuteTranslation as CuteTranslation
        cuteTranslation.format(index, *any)

        return translationAgent
    }

    override fun build(translationAgent: TranslationAgent): TextProxy {
        val cuteTranslation = translationAgent.cuteTranslation as CuteTranslation
        return TextProxyImpl.create(cuteTranslation.build())
    }
}