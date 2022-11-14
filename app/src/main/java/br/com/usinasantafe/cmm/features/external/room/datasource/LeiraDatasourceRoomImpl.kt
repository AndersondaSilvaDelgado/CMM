package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.LeiraModel
import br.com.usinasantafe.cmm.features.external.room.dao.LeiraDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.LeiraDatasourceRoom
import javax.inject.Inject

class LeiraDatasourceRoomImpl @Inject constructor (
    private val leiraDao: LeiraDao
): LeiraDatasourceRoom {

    override suspend fun addLeira(leiraModel: LeiraModel): Long {
        return leiraDao.insert(leiraModel)
    }

    override suspend fun deleteAllLeira() {
        leiraDao.deleteAll()
    }

}