package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.ROSAtiv
import br.com.usinasantafe.cmm.features.infra.models.toROSAtiv
import br.com.usinasantafe.cmm.features.infra.models.toROSAtivModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ROSAtivRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ROSAtivDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ROSAtivDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ROSAtivRepositoryImpl @Inject constructor(
    private val rOSAtivDatasourceRoom: ROSAtivDatasourceRoom,
    private val rOSAtivDatasourceWebService: ROSAtivDatasourceWebService
): ROSAtivRepository {

    override suspend fun addAllROSAtiv(rOSAtivList: List<ROSAtiv>) {
        for(rOSAtiv in rOSAtivList){
            val rOSAtivModel = rOSAtiv.toROSAtivModel()
            rOSAtivDatasourceRoom.addROSAtiv(rOSAtivModel)
        }
    }

    override suspend fun deleteAllROSAtiv() {
        rOSAtivDatasourceRoom.deleteAllROSAtiv()
    }

    override suspend fun getAllROSAtiv(): Flow<Result<List<ROSAtiv>>> {
        return flow {
            rOSAtivDatasourceWebService.getAllROSAtiv()
                .collect { result ->
                    result.onSuccess {rOSAtivModelList ->
                        val rOSAtivList = mutableListOf<ROSAtiv>()
                        for (rOSAtivModel in rOSAtivModelList){
                            rOSAtivList.add(rOSAtivModel.toROSAtiv())
                        }
                        emit(Result.success(rOSAtivList))
                    }
                }
        }
    }

}