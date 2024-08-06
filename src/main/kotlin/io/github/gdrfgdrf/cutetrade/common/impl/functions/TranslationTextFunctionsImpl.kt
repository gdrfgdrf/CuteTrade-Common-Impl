package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.impl.TextProxyImpl
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.TextProxy
import io.github.gdrfgdrf.cutetrade.common.translation.ClickTextAction
import io.github.gdrfgdrf.cutetrade.common.translation.HoverTextAction
import io.github.gdrfgdrf.cutetrade.common.translation.TranslationTextAgent
import io.github.gdrfgdrf.cutetranslationapi.text.CuteText
import net.minecraft.item.ItemStack
import net.minecraft.text.HoverEvent.ItemStackContent
import net.minecraft.text.Text

object TranslationTextFunctionsImpl : CommonFunctions.TranslationTextFunctions {
    override fun create(value: String): TranslationTextAgent {
        val cuteText = CuteText.of(value)
        return TranslationTextAgent(cuteText)
    }

    override fun clickAction(translationTextAgent: TranslationTextAgent, clickTextAction: ClickTextAction, any: Any) {
        val cuteText = translationTextAgent.cuteText as CuteText
        val content = any as String

        when (clickTextAction) {
            ClickTextAction.OPEN_URL -> cuteText.openUrl(content)
            ClickTextAction.OPEN_FILE -> cuteText.openFile(content)
            ClickTextAction.RUN_COMMAND -> cuteText.runCommand(content)
            ClickTextAction.SUGGEST_COMMAND -> cuteText.suggestCommand(content)
            ClickTextAction.CHANGE_PAGE -> cuteText.changePage(content)
            ClickTextAction.COPY_TO_CLIPBOARD -> cuteText.suggestCommand(content)
        }
    }

    override fun hoverAction(translationTextAgent: TranslationTextAgent, hoverTextAction: HoverTextAction, any: Any) {
        val cuteText = translationTextAgent.cuteText as CuteText

        when (hoverTextAction) {
            HoverTextAction.SHOW_TEXT -> cuteText.showText(any as String)
            HoverTextAction.SHOW_ITEM -> cuteText.showItem(any as ItemStackContent)
            HoverTextAction.SHOW_ENTITY -> cuteText.showText(any.toString())
        }
    }

    override fun format(translationTextAgent: TranslationTextAgent, vararg any: Any) {
        val cuteText = translationTextAgent.cuteText as CuteText
        cuteText.format(*any)
    }

    override fun createShowText(value: String): TextProxy {
        return TextProxyImpl.create(Text.of(value))
    }

    override fun createShowItem(itemStack: ItemStackProxy): Any {
        return ItemStackContent(itemStack.itemStack as ItemStack)
    }

    override fun createShowEntity(entity: Any): Any {
        TODO("Not yet implemented")
    }

    override fun build(translationTextAgent: TranslationTextAgent): TextProxy {
        val cuteText = translationTextAgent.cuteText as CuteText
        val text = cuteText.build()
        return TextProxyImpl.create(text)
    }
}