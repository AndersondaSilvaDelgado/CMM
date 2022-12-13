package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.stable.ParadaModel
import br.com.usinasantafe.cmm.features.external.room.dao.ParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ParadaDatasourceRoom
import javax.inject.Inject

class ParadaDatasourceRoomImpl @Inject constructor (
    private val paradaDao: ParadaDao
): ParadaDatasourceRoom {

    override suspend fun addAllParada(vararg paradaModels: ParadaModel) {
        paradaDao.insertAll(*paradaModels)
    }

    override suspend fun deleteAllParada() {
        paradaDao.deleteAll()
    }

}