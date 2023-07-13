package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.PropriedadeRoomModel

interface PropriedadeDatasourceRoom {

    suspend fun addAllPropriedade(vararg propriedadeRoomModels: PropriedadeRoomModel)

    suspend fun deleteAllPropriedade()

}