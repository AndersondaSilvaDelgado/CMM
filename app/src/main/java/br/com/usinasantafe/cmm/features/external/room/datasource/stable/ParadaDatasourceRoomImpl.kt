package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ParadaModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.stable.AtividadeModel
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

    override suspend fun listInIdParada(vararg idParadas: Long): List<ParadaModel> {
        return paradaDao.listInIdParada(*idParadas)
    }

}