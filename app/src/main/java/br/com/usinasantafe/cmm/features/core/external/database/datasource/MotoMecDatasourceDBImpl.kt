package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.MotoMecModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.MotoMecDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.MotoMecDatasourceDB
import javax.inject.Inject

class MotoMecDatasourceDBImpl @Inject constructor (
    private val motoMecDao: MotoMecDao
): MotoMecDatasourceDB {

    override suspend fun addMotoMec(motoMecModel: MotoMecModel): Long {
        return motoMecDao.insert(motoMecModel)
    }

    override suspend fun deleteAllMotoMec() {
        motoMecDao.deleteAll()
    }

}