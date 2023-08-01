package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.features.external.room.dao.variable.RespItemCheckListDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.RespItemCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.RespItemCheckListRoomModel
import javax.inject.Inject

class RespItemCheckListDatasourceRoomImpl @Inject constructor(
    private val respItemCheckListDao: RespItemCheckListDao
): RespItemCheckListDatasourceRoom {

    override suspend fun countRespItemCheckList(idCabec: Long): Int {
        return respItemCheckListDao.countRespItemCheckListIdCabec(idCabec)
    }

    override suspend fun insertRespItemCheckList(respItemCheckListRoomModel: RespItemCheckListRoomModel): Boolean {
        return respItemCheckListDao.insert(respItemCheckListRoomModel) > 0
    }

    override suspend fun deleteRespItemCheckList(idCabec: Long, idItem: Long): Boolean {
        return respItemCheckListDao.deleteRespItemCheckListIdCabecIdItem(idCabec, idItem) > 0
    }

    override suspend fun listRespItemCheckListIdCabec(idCabec: Long): List<RespItemCheckListRoomModel> {
        return respItemCheckListDao.listRespItemCheckListIdCabec(idCabec)
    }

}