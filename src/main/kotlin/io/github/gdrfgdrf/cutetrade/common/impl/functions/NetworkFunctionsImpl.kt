package io.github.gdrfgdrf.cutetrade.common.impl.functions

import io.github.gdrfgdrf.cutetrade.common.CommonFunctions
import io.github.gdrfgdrf.cutetrade.common.Constants
import io.github.gdrfgdrf.cutetrade.common.impl.PacketByteBufProxyImpl
import io.github.gdrfgdrf.cutetrade.common.network.interfaces.PacketAdapter
import io.github.gdrfgdrf.cutetrade.common.network.packet.C2SOperationPacketCommon
import io.github.gdrfgdrf.cutetrade.common.network.packet.S2COperationPacketCommon
import io.github.gdrfgdrf.cutetrade.common.proxy.PlayerProxy
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Identifier

object NetworkFunctionsImpl : CommonFunctions.NetworkFunctions {
    override fun createS2C(operatorName: String): PacketAdapter {
        return S2COperationPacketCommon(operatorName)
    }

    override fun createC2S(operatorName: String): PacketAdapter {
        return C2SOperationPacketCommon(operatorName)
    }

    override fun getOrCreateS2CIdentifier(): Any {
        return Constants.S2C_OPERATION
    }

    override fun getOrCreateC2SIdentifier(): Any {
        return Constants.C2S_OPERATION
    }

    override fun sendToServer(packetAdapter: PacketAdapter) {
        TODO()
    }

    override fun sendToClient(identifier: Any, playerProxy: PlayerProxy, packetAdapter: PacketAdapter) {
        val packetByteBuf = PacketByteBufs.create()
        val packetByteBufProxy = PacketByteBufProxyImpl.create(packetByteBuf)
        packetAdapter.write(packetByteBufProxy)

        ServerPlayNetworking.send(
            playerProxy.serverPlayerEntity as ServerPlayerEntity,
            identifier as Identifier,
            packetByteBuf
        )
    }
}