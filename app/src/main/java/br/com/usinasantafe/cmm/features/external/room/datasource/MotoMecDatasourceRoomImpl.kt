package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.MotoMecModel
import br.com.usinasantafe.cmm.features.external.room.dao.MotoMecDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.MotoMecDatasourceRoom
import javax.inject.Inject

class MotoMecDatasourceRoomImpl @Inject constructor (
    private val motoMecDao: MotoMecDao
): MotoMecDatasourceRoom {

    override suspend fun addMotoMec(motoMecModel: MotoMecModel): Long {
        return motoMecDao.insert(motoMecModel)
    }

    override suspend fun deleteAllMotoMec() {
        motoMecDao.deleteAll()
    }

}