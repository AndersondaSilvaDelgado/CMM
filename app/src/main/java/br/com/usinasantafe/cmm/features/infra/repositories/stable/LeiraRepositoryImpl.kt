package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Leira
import br.com.usinasantafe.cmm.features.infra.models.toLeira
import br.com.usinasantafe.cmm.features.infra.models.toLeiraModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.LeiraRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.LeiraDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.LeiraDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toItemOSMecanModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LeiraRepositoryImpl @Inject constructor(
    private val leiraDatasourceRoom: LeiraDatasourceRoom,
    private val leiraDatasourceWebService: LeiraDatasourceWebService
): LeiraRepository {

    override suspend fun addAllLeira(leiraList: List<Leira>) {
        leiraDatasourceRoom.addAllLeira(*leiraList.map { it.toLeiraModel() }.toTypedArray())
    }

    override suspend fun deleteAllLeira() {
        leiraDatasourceRoom.deleteAllLeira()
    }

    override suspend fun recoverAllLeira(): Flow<Result<List<Leira>>> {
        return flow {
            leiraDatasourceWebService.getAllLeira()
                .collect { result ->
                    result.onSuccess {leiraModelList ->
                        emit(Result.success(leiraModelList.map { it.toLeira() }))
                    }
                }
        }
    }

}