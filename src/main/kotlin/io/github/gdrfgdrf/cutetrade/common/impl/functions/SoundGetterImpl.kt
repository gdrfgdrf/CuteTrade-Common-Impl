package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.extension.createIdentifier
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

object SoundGetterImpl : CommonFunctions.SoundGetter {
    val START_SOUND = SoundEvent.of(createIdentifier("minecraft:entity.experience_orb.pickup"))
    val STATE_POSITIVE_SOUND = SoundEvent.of(createIdentifier("minecraft:block.note_block.harp"))
    val STATE_NEGATIVE_SOUND = SoundEvent.of(createIdentifier("minecraft:block.note_block.bass"))
    val ADD_ITEM_SOUND = SoundEvent.of(createIdentifier("minecraft:block.note_block.bell"))
    val REMOVE_ITEM_SOUND = SoundEvent.of(createIdentifier("minecraft:block.note_block.didgeridoo"))
    val TERMINATE_SOUND = SoundEvent.of(createIdentifier("minecraft:block.anvil.land"))
    val FINISH_SOUND = SoundEvents.ENTITY_PLAYER_LEVELUP

    override fun getTradeStartSound(): Any = START_SOUND

    override fun getStatePositiveSound(): Any = STATE_POSITIVE_SOUND

    override fun getStateNegativeSound(): Any = STATE_NEGATIVE_SOUND

    override fun getAddItemSound(): Any = ADD_ITEM_SOUND

    override fun getRemoveItemSound(): Any = REMOVE_ITEM_SOUND

    override fun getTerminateSound(): Any = TERMINATE_SOUND

    override fun getFinishSound(): Any = FINISH_SOUND
}