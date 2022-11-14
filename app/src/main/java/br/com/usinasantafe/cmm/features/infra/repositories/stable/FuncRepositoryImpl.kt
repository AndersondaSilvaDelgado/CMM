package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Func
import br.com.usinasantafe.cmm.features.infra.models.toFunc
import br.com.usinasantafe.cmm.features.infra.models.toFuncModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.FuncRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.FuncDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.FuncDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FuncRepositoryImpl @Inject constructor(
    private val funcDatasourceRoom: FuncDatasourceRoom,
    private val funcDatasourceWebService: FuncDatasourceWebService
): FuncRepository {

    override suspend fun addAllFunc(funcList: List<Func>) {
        for(func in funcList){
            val funcModel = func.toFuncModel()
            funcDatasourceRoom.addFunc(funcModel)
        }
    }

    override suspend fun deleteAllFunc() {
        funcDatasourceRoom.deleteAllFunc()
    }

    override suspend fun getAllFunc(): Flow<Result<List<Func>>> {
        return flow {
            funcDatasourceWebService.getAllFunc()
                .collect { result ->
                    result.onSuccess {funcModelList ->
                        val funcList = mutableListOf<Func>()
                        for (funcModel in funcModelList){
                            funcList.add(funcModel.toFunc())
                        }
                        emit(Result.success(funcList))
                    }
                }
        }
    }

    override suspend fun checkFuncNro(nroFunc: String): Boolean {
        return funcDatasourceRoom.checkFuncNro(nroFunc.toLong())
    }

}