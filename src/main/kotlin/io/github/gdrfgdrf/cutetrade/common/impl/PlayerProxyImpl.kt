package io.github.gdrfgdrf.cutetrade.common.impl

import io.github.gdrfgdrf.cutetrade.CuteTrade
import io.github.gdrfgdrf.cutetrade.common.enums.TranslationType
import io.github.gdrfgdrf.cutetrade.common.proxy.ItemStackProxy
import io.github.gdrfgdrf.cutetrade.common.proxy.PlayerProxy
import io.github.gdrfgdrf.cutetrade.common.trade.screen.handler.ScreenHandlerAgent
import io.github.gdrfgdrf.cutetrade.common.translation.TranslationAgent
import io.github.gdrfgdrf.cutetrade.common.translation.TranslationTextAgent
import io.github.gdrfgdrf.cutetrade.extension.logInfo
import io.github.gdrfgdrf.cutetrade.screen.factory.TradeScreenHandlerFactory
import io.github.gdrfgdrf.cutetranslationapi.text.CuteText
import io.github.gdrfgdrf.cutetranslationapi.text.CuteTranslation
import net.minecraft.item.ItemStack
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundEvent
import net.minecraft.text.Text

class PlayerProxyImpl(
    var name: String,
    var player: ServerPlayerEntity
) : PlayerProxy(name, player) {
    override fun send(prefix: TranslationTextAgent, message: TranslationAgent) {
        message.insert(0, prefix)
        val finalMessage = message.build()
        player.sendMessage(finalMessage.text as Text)
    }

    override fun getTranslation(translationType: TranslationType, key: String): TranslationAgent {
        if (CuteTrade.PLAYER_TRANSLATION_PROVIDER == null) {
            throw IllegalStateException("Player translation provider is loaded normally")
        }

        val fullKey = translationType.rootKey + key
        val message = CuteTrade.PLAYER_TRANSLATION_PROVIDER!!.get(name, fullKey)
        val cuteTranslation = CuteTranslation.of(message)

        return TranslationAgent(cuteTranslation, this)
    }

    override fun getText(translationType: TranslationType, key: String): TranslationTextAgent {
        if (CuteTrade.PLAYER_TRANSLATION_PROVIDER == null) {
            throw IllegalStateException("Player translation provider is loaded normally")
        }

        val fullKey = translationType.rootKey + key
        val message = CuteTrade.PLAYER_TRANSLATION_PROVIDER!!.get(name, fullKey)
        val cuteText = CuteText.of(message)

        return TranslationTextAgent(cuteText)
    }

    override fun offerOrDrop(itemStack: ItemStackProxy) {
        player.inventory.offerOrDrop(itemStack.itemStack as ItemStack)
    }

    override fun openHandledScreen(factory: Any) {
        player.openHandledScreen(factory as NamedScreenHandlerFactory)
    }

    override fun closeHandledScreen() {
        player.closeHandledScreen()
    }

    override fun playSound(any: Any, volume: Float, pitch: Float) {
        player.playSound(any as SoundEvent, volume, pitch)
    }

    override fun currentScreenHandler(): ScreenHandlerAgent {
        return ScreenHandlerAgent(player.currentScreenHandler)
    }

    override fun isDisconnected(): Boolean {
        return player.isDisconnected
    }

    override fun isDead(): Boolean {
        "player $playerName isDead: ${player.isDead}".logInfo()
        return player.isDead
    }
}