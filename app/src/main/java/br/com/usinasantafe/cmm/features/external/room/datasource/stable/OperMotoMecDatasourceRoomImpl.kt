package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.OperMotoMecRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.OperMotoMecDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.OperMotoMecDatasourceRoom
import javax.inject.Inject

class OperMotoMecDatasourceRoomImpl @Inject constructor (
    private val operMotoMecDao: OperMotoMecDao
): OperMotoMecDatasourceRoom {

    override suspend fun addAllOperMotoMec(vararg operMotoMecRoomModels: OperMotoMecRoomModel) {
        operMotoMecDao.insertAll(*operMotoMecRoomModels)
    }

    override suspend fun deleteAllOperMotoMec() {
        operMotoMecDao.deleteAll()
    }

}