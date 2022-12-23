package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ROSAtivModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ROSAtivDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ROSAtivDatasourceRoom
import javax.inject.Inject

class ROSAtivDatasourceRoomImpl @Inject constructor (
    private val rOSAtivDao: ROSAtivDao
): ROSAtivDatasourceRoom {

    override suspend fun addAllROSAtiv(vararg rOSAtivModels: ROSAtivModel) {
        rOSAtivDao.insertAll(*rOSAtivModels)
    }

    override suspend fun deleteAllROSAtiv() {
        rOSAtivDao.deleteAll()
    }

    override suspend fun listROSAtiv(idOS: Long): List<ROSAtivModel> {
        return rOSAtivDao.listIdOS(idOS)
    }

}