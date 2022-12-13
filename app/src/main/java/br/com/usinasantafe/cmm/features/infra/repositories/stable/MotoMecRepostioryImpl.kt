package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.MotoMec
import br.com.usinasantafe.cmm.features.infra.models.stable.toMotoMec
import br.com.usinasantafe.cmm.features.infra.models.stable.toMotoMecModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.MotoMecRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.MotoMecDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.MotoMecDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MotoMecRepostioryImpl @Inject constructor(
    private val motoMecDatasourceRoom: MotoMecDatasourceRoom,
    private val motoMecDatasourceWebService: MotoMecDatasourceWebService
): MotoMecRepository {

    override suspend fun addAllMotoMec(motoMecList: List<MotoMec>) {
        motoMecDatasourceRoom.addAllMotoMec(*motoMecList.map { it.toMotoMecModel() }.toTypedArray())
    }

    override suspend fun deleteAllMotoMec() {
        motoMecDatasourceRoom.deleteAllMotoMec()
    }

    override suspend fun recoverAllMotoMec(): Flow<Result<List<MotoMec>>> {
        return flow {
            motoMecDatasourceWebService.getAllMotoMec()
                .collect { result ->
                    result.onSuccess {motoMecModelList ->
                        emit(Result.success(motoMecModelList.map { it.toMotoMec() }))
                    }
                }
        }
    }

}