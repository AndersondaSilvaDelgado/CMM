package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Func
import br.com.usinasantafe.cmm.features.core.infra.models.toFunc
import br.com.usinasantafe.cmm.features.core.infra.models.toFuncModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.FuncRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.FuncDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.FuncDatasourceWeb
import javax.inject.Inject

class FuncRepositoryImpl @Inject constructor(
    private val funcDatasourceDB: FuncDatasourceDB,
    private val funcDatasourceWeb: FuncDatasourceWeb
): FuncRepository {

    override suspend fun addAllFunc(funcList: List<Func>) {
        for(func in funcList){
            val funcModel = func.toFuncModel()
            funcDatasourceDB.addFunc(funcModel)
        }
    }

    override suspend fun deleteAllFunc() {
        funcDatasourceDB.deleteAllFunc()
    }

    override suspend fun getAllFunc(): List<Func> {
        val funcModelList = funcDatasourceWeb.getAllFunc()
        val funcList = mutableListOf<Func>()
        for (funcModel in funcModelList){
            funcList.add(funcModel.toFunc())
        }
        return funcList
    }

}