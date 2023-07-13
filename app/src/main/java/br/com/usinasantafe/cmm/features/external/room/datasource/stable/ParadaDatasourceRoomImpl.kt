package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ParadaRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ParadaDatasourceRoom
import javax.inject.Inject

class ParadaDatasourceRoomImpl @Inject constructor (
    private val paradaDao: ParadaDao
): ParadaDatasourceRoom {

    override suspend fun addAllParada(vararg paradaRoomModels: ParadaRoomModel) {
        paradaDao.insertAll(*paradaRoomModels)
    }

    override suspend fun deleteAllParada() {
        paradaDao.deleteAll()
    }

    override suspend fun listInIdParada(vararg idParadas: Long): List<ParadaRoomModel> {
        return paradaDao.listInIdParada(*idParadas)
    }

}