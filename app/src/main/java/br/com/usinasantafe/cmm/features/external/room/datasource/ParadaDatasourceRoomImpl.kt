package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.ParadaModel
import br.com.usinasantafe.cmm.features.external.room.dao.ParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ParadaDatasourceRoom
import javax.inject.Inject

class ParadaDatasourceRoomImpl @Inject constructor (
    private val paradaDao: ParadaDao
): ParadaDatasourceRoom {

    override suspend fun addParada(paradaModel: ParadaModel): Long {
        return paradaDao.insert(paradaModel)
    }

    override suspend fun deleteAllParada() {
        paradaDao.deleteAll()
    }

}