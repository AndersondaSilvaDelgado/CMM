package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.FuncModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.FuncDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.FuncDatasourceDB
import javax.inject.Inject

class FuncDatasourceDBImpl @Inject constructor (
    private val funcDao: FuncDao
): FuncDatasourceDB {

    override suspend fun addFunc(funcModel: FuncModel): Long {
        return funcDao.insert(funcModel)
    }

    override suspend fun deleteAllFunc() {
        funcDao.deleteAll()
    }

}