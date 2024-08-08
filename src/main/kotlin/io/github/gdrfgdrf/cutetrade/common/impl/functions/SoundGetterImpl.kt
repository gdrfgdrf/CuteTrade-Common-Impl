package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.extension.createIdentifier
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

object SoundGetterImpl : CommonFunctions.SoundGetter {
    val START_SOUND = SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP
    val STATE_POSITIVE_SOUND = SoundEvents.BLOCK_NOTE_BLOCK_HARP
    val STATE_NEGATIVE_SOUND = SoundEvents.BLOCK_NOTE_BLOCK_BASS
    val ADD_ITEM_SOUND = SoundEvents.BLOCK_NOTE_BLOCK_BELL
    val REMOVE_ITEM_SOUND = SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO
    val TERMINATE_SOUND = SoundEvents.BLOCK_ANVIL_LAND
    val FINISH_SOUND = SoundEvents.ENTITY_PLAYER_LEVELUP

    override fun getTradeStartSound(): Any = START_SOUND

    override fun getStatePositiveSound(): Any = STATE_POSITIVE_SOUND

    override fun getStateNegativeSound(): Any = STATE_NEGATIVE_SOUND

    override fun getAddItemSound(): Any = ADD_ITEM_SOUND

    override fun getRemoveItemSound(): Any = REMOVE_ITEM_SOUND

    override fun getTerminateSound(): Any = TERMINATE_SOUND

    override fun getFinishSound(): Any = FINISH_SOUND
}