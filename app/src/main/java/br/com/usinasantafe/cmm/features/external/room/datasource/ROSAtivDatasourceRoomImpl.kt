package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel
import br.com.usinasantafe.cmm.features.external.room.dao.ROSAtivDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ROSAtivDatasourceRoom
import javax.inject.Inject

class ROSAtivDatasourceRoomImpl @Inject constructor (
    private val rOSAtivDao: ROSAtivDao
): ROSAtivDatasourceRoom {

    override suspend fun addROSAtiv(rOSAtivModel: ROSAtivModel): Long {
        return rOSAtivDao.insert(rOSAtivModel)
    }

    override suspend fun deleteAllROSAtiv() {
        rOSAtivDao.deleteAll()
    }

}