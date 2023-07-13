package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.features.external.room.dao.variable.ApontFertDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.ApontFertRoomModel
import javax.inject.Inject

class ApontFertDatasourceRoomImpl @Inject constructor (
    private val apontFertDao: ApontFertDao
): ApontFertDatasourceRoom {

    override fun checkApontFertSend(): Boolean {
        return true
    }

    override suspend fun insertApontFert(apontFertRoomModel: ApontFertRoomModel): Boolean {
        return apontFertDao.insert(apontFertRoomModel) > 0
    }

}