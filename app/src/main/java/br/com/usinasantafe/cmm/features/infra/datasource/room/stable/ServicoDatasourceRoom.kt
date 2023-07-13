package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ServicoRoomModel

interface ServicoDatasourceRoom {

    suspend fun addAllServico(vararg servicoRoomModels: ServicoRoomModel)

    suspend fun deleteAllServico()

}