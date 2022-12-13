package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.ROSAtiv
import br.com.usinasantafe.cmm.features.infra.models.stable.toROSAtiv
import br.com.usinasantafe.cmm.features.infra.models.stable.toROSAtivModel
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
        rOSAtivDatasourceRoom.addAllROSAtiv(*rOSAtivList.map { it.toROSAtivModel() }.toTypedArray())
    }

    override suspend fun deleteAllROSAtiv() {
        rOSAtivDatasourceRoom.deleteAllROSAtiv()
    }

    override suspend fun recoverAllROSAtiv(): Flow<Result<List<ROSAtiv>>> {
        return flow {
            rOSAtivDatasourceWebService.getAllROSAtiv()
                .collect { result ->
                    result.onSuccess {rOSAtivModelList ->
                        emit(Result.success(rOSAtivModelList.map { it.toROSAtiv() }))
                    }
                }
        }
    }

    override suspend fun recoverROSAtiv(nroOS: String): Flow<Result<List<ROSAtiv>>> {
        return flow {
            rOSAtivDatasourceWebService.recoverROSAtiv(nroOS)
                .collect { result ->
                    result.onSuccess {rOSAtivModelList ->
                        emit(Result.success(rOSAtivModelList.map { it.toROSAtiv() }))
                    }
                }
        }
    }

    override suspend fun listROSAtiv(idOS: Long): List<ROSAtiv> {
        return rOSAtivDatasourceRoom.listROSAtiv(idOS).map { it.toROSAtiv() }
    }

}