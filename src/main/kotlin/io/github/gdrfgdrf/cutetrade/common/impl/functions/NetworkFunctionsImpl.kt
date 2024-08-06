package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.network.interfaces.PacketAdapter
import io.github.gdrfgdrf.cutetrade.common.proxy.PlayerProxy
import io.github.gdrfgdrf.cutetrade.network.packet.C2SOperationPacket
import io.github.gdrfgdrf.cutetrade.network.packet.S2COperationPacket
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.network.packet.CustomPayload
import net.minecraft.server.network.ServerPlayerEntity

object NetworkFunctionsImpl : CommonFunctions.NetworkFunctions {
    override fun createS2C(operatorName: String): PacketAdapter {
        return S2COperationPacket(operatorName)
    }

    override fun createC2S(operatorName: String): PacketAdapter {
        return C2SOperationPacket(operatorName)
    }

    override fun sendToServer(packetAdapter: PacketAdapter) {
        val customPayload = packetAdapter as CustomPayload

    }

    override fun sendToClient(identifier: Any, playerProxy: PlayerProxy, packetAdapter: PacketAdapter) {
        val payload = packetAdapter as CustomPayload
        ServerPlayNetworking.send(playerProxy.serverPlayerEntity as ServerPlayerEntity, payload)
    }
}