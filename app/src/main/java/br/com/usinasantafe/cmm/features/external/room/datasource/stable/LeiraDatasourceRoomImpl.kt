package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.LeiraRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.LeiraDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.LeiraDatasourceRoom
import javax.inject.Inject

class LeiraDatasourceRoomImpl @Inject constructor (
    private val leiraDao: LeiraDao
): LeiraDatasourceRoom {

    override suspend fun addAllLeira(vararg leiraRoomModels: LeiraRoomModel) {
        leiraDao.insertAll(*leiraRoomModels)
    }

    override suspend fun deleteAllLeira() {
        leiraDao.deleteAll()
    }

}