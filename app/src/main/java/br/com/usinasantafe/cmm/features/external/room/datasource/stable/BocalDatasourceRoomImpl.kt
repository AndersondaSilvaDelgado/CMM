package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.BocalRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.BocalDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.BocalDatasourceRoom
import javax.inject.Inject

class BocalDatasourceRoomImpl @Inject constructor (
    private val bocalDao: BocalDao
): BocalDatasourceRoom {

    override suspend fun addAllBocal(vararg bocalRoomModels: BocalRoomModel) {
        bocalDao.insertAll(*bocalRoomModels)
    }

    override suspend fun deleteAllBocal() {
        bocalDao.deleteAll()
    }

}