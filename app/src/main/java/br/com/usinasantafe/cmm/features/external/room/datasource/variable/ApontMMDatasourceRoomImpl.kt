package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.features.external.room.dao.variable.ApontMMDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontMMRoomModel
import javax.inject.Inject

class ApontMMDatasourceRoomImpl @Inject constructor (
    private val apontMMDao: ApontMMDao
): ApontMMDatasourceRoom {

    override suspend fun insertApontMM(apontMMRoomModel: ApontMMRoomModel): Boolean {
        return apontMMDao.insert(apontMMRoomModel) > 0
    }

    override suspend fun listApontIdBol(idBol: Long): List<ApontMMRoomModel> {
        return apontMMDao.listApontIdBol(idBol)
    }

}