package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.FrenteModel
import br.com.usinasantafe.cmm.features.external.room.dao.FrenteDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.FrenteDatasourceRoom
import javax.inject.Inject

class FrenteDatasourceRoomImpl @Inject constructor (
    private val frenteDao: FrenteDao
): FrenteDatasourceRoom {

    override suspend fun addAllFrente(vararg frenteModels: FrenteModel) {
        frenteDao.insertAll(*frenteModels)
    }

    override suspend fun deleteAllFrente() {
        frenteDao.deleteAll()
    }

}