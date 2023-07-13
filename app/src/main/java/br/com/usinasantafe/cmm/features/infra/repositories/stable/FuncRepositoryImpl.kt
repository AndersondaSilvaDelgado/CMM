package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Func
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toFunc
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toFuncModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.FuncRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.FuncDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.FuncDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FuncRepositoryImpl @Inject constructor(
    private val funcDatasourceRoom: FuncDatasourceRoom,
    private val funcDatasourceWebService: FuncDatasourceWebService
): FuncRepository {

    override suspend fun addAllFunc(funcList: List<Func>) {
        funcDatasourceRoom.addAllFunc(*funcList.map { it.toFuncModel() }.toTypedArray())
    }

    override suspend fun deleteAllFunc() {
        funcDatasourceRoom.deleteAllFunc()
    }

    override suspend fun recoverAllFunc(): Flow<Result<List<Func>>> {
        return flow {
            funcDatasourceWebService.getAllFunc()
                .collect { result ->
                    result.onSuccess {funcModelList ->
                        emit(Result.success(funcModelList.map { it.toFunc() }))
                    }
                }
        }
    }

    override suspend fun checkFuncNro(nroFunc: String): Boolean {
        return funcDatasourceRoom.checkFuncNro(nroFunc.toLong())
    }

}