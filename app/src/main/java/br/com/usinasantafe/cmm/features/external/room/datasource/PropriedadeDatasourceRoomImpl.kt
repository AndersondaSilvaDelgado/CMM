package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.PropriedadeModel
import br.com.usinasantafe.cmm.features.external.room.dao.PropriedadeDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.PropriedadeDatasourceRoom
import javax.inject.Inject

class PropriedadeDatasourceRoomImpl @Inject constructor (
    private val propriedadeDao: PropriedadeDao
): PropriedadeDatasourceRoom {

    override suspend fun addPropriedade(propriedadeModel: PropriedadeModel): Long {
        return propriedadeDao.insert(propriedadeModel)
    }

    override suspend fun deleteAllPropriedade() {
        propriedadeDao.deleteAll()
    }

}