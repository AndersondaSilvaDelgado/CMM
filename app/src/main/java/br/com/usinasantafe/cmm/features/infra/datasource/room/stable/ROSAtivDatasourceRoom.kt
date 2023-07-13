package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ROSAtivRoomModel

interface ROSAtivDatasourceRoom {

    suspend fun addAllROSAtiv(vararg rOSAtivRoomModels: ROSAtivRoomModel)

    suspend fun deleteAllROSAtiv()

    suspend fun listROSAtiv(idOS: Long): List<ROSAtivRoomModel>

}