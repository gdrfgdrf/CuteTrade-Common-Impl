package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.common.proxy.TextProxy
import net.minecraft.text.Text

class TextProxyImpl private constructor(text: Any): TextProxy(text) {
    override fun string(): String = get().string

    fun get(): Text = text as Text

    companion object {
        fun create(text: Text): TextProxy = TextProxyImpl(text)
    }
}