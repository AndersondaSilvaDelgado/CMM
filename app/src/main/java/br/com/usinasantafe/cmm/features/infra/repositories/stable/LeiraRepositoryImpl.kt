package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Leira
import br.com.usinasantafe.cmm.features.infra.models.toLeira
import br.com.usinasantafe.cmm.features.infra.models.toLeiraModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.LeiraRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.LeiraDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.LeiraDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LeiraRepositoryImpl @Inject constructor(
    private val leiraDatasourceRoom: LeiraDatasourceRoom,
    private val leiraDatasourceWebService: LeiraDatasourceWebService
): LeiraRepository {

    override suspend fun addAllLeira(leiraList: List<Leira>) {
        for(leira in leiraList){
            val leiraModel = leira.toLeiraModel()
            leiraDatasourceRoom.addLeira(leiraModel)
        }
    }

    override suspend fun deleteAllLeira() {
        leiraDatasourceRoom.deleteAllLeira()
    }

    override suspend fun getAllLeira(): Flow<Result<List<Leira>>> {
        return flow {
            leiraDatasourceWebService.getAllLeira()
                .collect { result ->
                    result.onSuccess {leiraModelList ->
                        val leiraList = mutableListOf<Leira>()
                        for (leiraModel in leiraModelList){
                            leiraList.add(leiraModel.toLeira())
                        }
                        emit(Result.success(leiraList))
                    }
                }
        }
    }

}