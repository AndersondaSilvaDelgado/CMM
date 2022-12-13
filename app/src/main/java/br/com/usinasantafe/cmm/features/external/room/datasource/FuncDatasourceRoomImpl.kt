package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.stable.FuncModel
import br.com.usinasantafe.cmm.features.external.room.dao.FuncDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.FuncDatasourceRoom
import javax.inject.Inject

class FuncDatasourceRoomImpl @Inject constructor (
    private val funcDao: FuncDao
): FuncDatasourceRoom {

    override suspend fun addAllFunc(vararg funcModels: FuncModel) {
        funcDao.insertAll(*funcModels)
    }

    override suspend fun deleteAllFunc() {
        funcDao.deleteAll()
    }

    override suspend fun checkFuncNro(nroFunc: Long): Boolean {
        return funcDao.checkMatric(nroFunc) > 0
    }

}