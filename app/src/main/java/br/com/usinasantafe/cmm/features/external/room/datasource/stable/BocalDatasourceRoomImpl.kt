package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.BocalModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.BocalDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.BocalDatasourceRoom
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