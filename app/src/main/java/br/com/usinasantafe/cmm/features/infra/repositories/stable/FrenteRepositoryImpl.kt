package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Frente
import br.com.usinasantafe.cmm.features.infra.models.stable.toFrente
import br.com.usinasantafe.cmm.features.infra.models.stable.toFrenteModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.FrenteRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.FrenteDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.FrenteDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FrenteRepositoryImpl @Inject constructor(
    private val frenteDatasourceRoom: FrenteDatasourceRoom,
    private val frenteDatasourceWebService: FrenteDatasourceWebService
): FrenteRepository {

    override suspend fun addAllFrente(frenteList: List<Frente>) {
        frenteDatasourceRoom.addAllFrente(*frenteList.map { it.toFrenteModel() }.toTypedArray())
    }

    override suspend fun deleteAllFrente() {
        frenteDatasourceRoom.deleteAllFrente()
    }

    override suspend fun recoverAllFrente(): Flow<Result<List<Frente>>> {
        return flow {
            frenteDatasourceWebService.getAllFrente()
                .collect { result ->
                    result.onSuccess {frenteModelList ->
                        emit(Result.success(frenteModelList.map { it.toFrente() }))
                    }
                }
        }
    }

}