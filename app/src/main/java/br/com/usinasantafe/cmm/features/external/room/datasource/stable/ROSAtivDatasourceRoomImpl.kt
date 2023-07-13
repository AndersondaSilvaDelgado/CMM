package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ROSAtivRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ROSAtivDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ROSAtivDatasourceRoom
import javax.inject.Inject

class ROSAtivDatasourceRoomImpl @Inject constructor (
    private val rOSAtivDao: ROSAtivDao
): ROSAtivDatasourceRoom {

    override suspend fun addAllROSAtiv(vararg rOSAtivRoomModels: ROSAtivRoomModel) {
        rOSAtivDao.insertAll(*rOSAtivRoomModels)
    }

    override suspend fun deleteAllROSAtiv() {
        rOSAtivDao.deleteAll()
    }

    override suspend fun listROSAtiv(idOS: Long): List<ROSAtivRoomModel> {
        return rOSAtivDao.listIdOS(idOS)
    }

}