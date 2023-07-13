package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.PropriedadeRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.PropriedadeDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.PropriedadeDatasourceRoom
import javax.inject.Inject

class PropriedadeDatasourceRoomImpl @Inject constructor (
    private val propriedadeDao: PropriedadeDao
): PropriedadeDatasourceRoom {

    override suspend fun addAllPropriedade(vararg propriedadeRoomModels: PropriedadeRoomModel) {
        propriedadeDao.insertAll(*propriedadeRoomModels)
    }

    override suspend fun deleteAllPropriedade() {
        propriedadeDao.deleteAll()
    }

}