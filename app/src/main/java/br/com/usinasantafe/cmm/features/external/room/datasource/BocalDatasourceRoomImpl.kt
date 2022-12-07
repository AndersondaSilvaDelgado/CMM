package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.BocalModel
import br.com.usinasantafe.cmm.features.external.room.dao.BocalDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.BocalDatasourceRoom
import javax.inject.Inject

class BocalDatasourceRoomImpl @Inject constructor (
    private val bocalDao: BocalDao
): BocalDatasourceRoom {

    override suspend fun addAllBocal(vararg bocalModels: BocalModel) {
        bocalDao.insertAll(*bocalModels)
    }

    override suspend fun deleteAllBocal() {
        bocalDao.deleteAll()
    }

}