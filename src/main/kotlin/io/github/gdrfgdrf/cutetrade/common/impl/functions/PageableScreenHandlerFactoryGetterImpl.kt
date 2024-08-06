package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.proxy.TextProxy
import io.github.gdrfgdrf.cutetrade.page.PageableScreenHandlerFactory
import net.minecraft.text.Text

object PageableScreenHandlerFactoryGetterImpl : CommonFunctions.PageableScreenHandlerFactoryGetter {
    override fun create(title: TextProxy): Any {
        return PageableScreenHandlerFactory(title.text as Text)
    }
}