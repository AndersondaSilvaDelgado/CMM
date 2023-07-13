package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.features.external.room.dao.variable.CabecCheckListDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.CabecCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.CabecCheckListRoomModel
import javax.inject.Inject

class CabecCheckListDatasourceRoomImpl @Inject constructor(
    private val cabecCheckListDao: CabecCheckListDao
): CabecCheckListDatasourceRoom {

    override suspend fun getCabecCheckListAberto(): CabecCheckListRoomModel {
        TODO("Not yet implemented")
    }

    override suspend fun insertCabecCheckList(cabecCheckListRoomModel: CabecCheckListRoomModel): Boolean {
        return cabecCheckListDao.insert(cabecCheckListRoomModel) > 0
    }

}