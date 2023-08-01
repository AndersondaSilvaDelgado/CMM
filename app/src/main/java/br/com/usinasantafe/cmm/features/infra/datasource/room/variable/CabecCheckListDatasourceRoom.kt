package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.room.variable.CabecCheckListRoomModel

interface CabecCheckListDatasourceRoom {

    suspend fun closeCabecCheckList(cabecCheckListRoomModel: CabecCheckListRoomModel): Boolean

    suspend fun listCabecCheckListSend(): List<CabecCheckListRoomModel>

    suspend fun getCabecCheckListOpen(): CabecCheckListRoomModel

    suspend fun insertCabecCheckList(cabecCheckListRoomModel: CabecCheckListRoomModel): Boolean

    suspend fun setStatusSent(idCabec: Long): Boolean

}