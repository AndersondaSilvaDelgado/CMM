package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.FrenteModel
import br.com.usinasantafe.cmm.features.external.room.dao.FrenteDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.FrenteDatasourceRoom
import javax.inject.Inject

class FrenteDatasourceRoomImpl @Inject constructor (
    private val frenteDao: FrenteDao
): FrenteDatasourceRoom {

    override suspend fun addFrente(frenteModel: FrenteModel): Long {
        return frenteDao.insert(frenteModel)
    }

    override suspend fun deleteAllFrente() {
        frenteDao.deleteAll()
    }

}