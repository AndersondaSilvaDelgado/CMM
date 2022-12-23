package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.OperMotoMec
import br.com.usinasantafe.cmm.features.infra.models.stable.toMotoMec
import br.com.usinasantafe.cmm.features.infra.models.stable.toMotoMecModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OperMotoMecRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.OperMotoMecDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.OperMotoMecDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OperMotoMecRepostioryImpl @Inject constructor(
    private val operMotoMecDatasourceRoom: OperMotoMecDatasourceRoom,
    private val operMotoMecDatasourceWebService: OperMotoMecDatasourceWebService
): OperMotoMecRepository {

    override suspend fun addAllOperMotoMec(operMotoMecList: List<OperMotoMec>) {
        operMotoMecDatasourceRoom.addAllOperMotoMec(*operMotoMecList.map { it.toMotoMecModel() }.toTypedArray())
    }

    override suspend fun deleteAllOperMotoMec() {
        operMotoMecDatasourceRoom.deleteAllOperMotoMec()
    }

    override suspend fun recoverAllOperMotoMec(): Flow<Result<List<OperMotoMec>>> {
        return flow {
            operMotoMecDatasourceWebService.getAllOperMotoMec()
                .collect { result ->
                    result.onSuccess {motoMecModelList ->
                        emit(Result.success(motoMecModelList.map { it.toMotoMec() }))
                    }
                }
        }
    }

}