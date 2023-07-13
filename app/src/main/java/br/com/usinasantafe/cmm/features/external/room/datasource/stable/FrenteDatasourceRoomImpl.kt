package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.FrenteRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.FrenteDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.FrenteDatasourceRoom
import javax.inject.Inject

class FrenteDatasourceRoomImpl @Inject constructor (
    private val frenteDao: FrenteDao
): FrenteDatasourceRoom {

    override suspend fun addAllFrente(vararg frenteRoomModels: FrenteRoomModel) {
        frenteDao.insertAll(*frenteRoomModels)
    }

    override suspend fun deleteAllFrente() {
        frenteDao.deleteAll()
    }

}