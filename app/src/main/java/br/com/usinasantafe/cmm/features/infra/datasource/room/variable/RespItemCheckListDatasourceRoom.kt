package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.room.variable.RespItemCheckListRoomModel

interface RespItemCheckListDatasourceRoom {

    suspend fun countRespItemCheckList(idCabec: Long): Int

    suspend fun deleteRespItemCheckList(idCabec: Long, idItem: Long): Boolean

    suspend fun insertRespItemCheckList(respItemCheckListRoomModel: RespItemCheckListRoomModel): Boolean

    suspend fun listRespItemCheckListIdCabec(idCabec: Long): List<RespItemCheckListRoomModel>

}