package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import net.minecraft.util.Identifier

object MainFunctionsImpl : CommonFunctions.MainFunctions {
    override fun createIdentifier(namespace: String, path: String): Any {
        return Identifier.of(namespace, path)!!
    }
}