package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.FrenteModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.FrenteDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.FrenteDatasourceRoom
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