package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.OperMotoMecModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.OperMotoMecDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.OperMotoMecDatasourceRoom
import javax.inject.Inject

class OperMotoMecDatasourceRoomImpl @Inject constructor (
    private val operMotoMecDao: OperMotoMecDao
): OperMotoMecDatasourceRoom {

    override suspend fun addAllOperMotoMec(vararg operMotoMecModels: OperMotoMecModel) {
        operMotoMecDao.insertAll(*operMotoMecModels)
    }

    override suspend fun deleteAllOperMotoMec() {
        operMotoMecDao.deleteAll()
    }

}