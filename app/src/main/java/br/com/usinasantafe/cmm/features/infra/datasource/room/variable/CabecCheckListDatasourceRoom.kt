package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.room.variable.CabecCheckListRoomModel

interface CabecCheckListDatasourceRoom {

    suspend fun insertCabecCheckList(cabecCheckListRoomModel: CabecCheckListRoomModel): Boolean

    suspend fun getCabecCheckListAberto(): CabecCheckListRoomModel

}