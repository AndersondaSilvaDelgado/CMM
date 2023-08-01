package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.external.room.dao.variable.CabecCheckListDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.CabecCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.CabecCheckListRoomModel
import javax.inject.Inject

class CabecCheckListDatasourceRoomImpl @Inject constructor(
    private val cabecCheckListDao: CabecCheckListDao
): CabecCheckListDatasourceRoom {

    override suspend fun closeCabecCheckList(cabecCheckListRoomModel: CabecCheckListRoomModel): Boolean {
        cabecCheckListRoomModel.statusData = StatusData.CLOSE
        cabecCheckListRoomModel.statusSend = StatusSend.SEND
        return cabecCheckListDao.update(cabecCheckListRoomModel) > 0
    }

    override suspend fun listCabecCheckListSend(): List<CabecCheckListRoomModel> {
        return cabecCheckListDao.listCabecStatusSend(StatusSend.SEND)
    }

    override suspend fun getCabecCheckListOpen(): CabecCheckListRoomModel {
        return cabecCheckListDao.listCabecStatusData(StatusData.OPEN).single()
    }

    override suspend fun insertCabecCheckList(cabecCheckListRoomModel: CabecCheckListRoomModel): Boolean {
        return cabecCheckListDao.insert(cabecCheckListRoomModel) > 0
    }

    override suspend fun setStatusSent(idCabec: Long): Boolean {
        var cabecCheckListRoomModel = cabecCheckListDao.listCabecIdCabec(idCabec).single()
        cabecCheckListRoomModel.statusSend = StatusSend.SENT
        return cabecCheckListDao.update(cabecCheckListRoomModel) > 0
    }

}