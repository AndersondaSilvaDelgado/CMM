package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Frente
import br.com.usinasantafe.cmm.features.infra.models.toFrente
import br.com.usinasantafe.cmm.features.infra.models.toFrenteModel
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
        for(frente in frenteList){
            val frenteModel = frente.toFrenteModel()
            frenteDatasourceRoom.addFrente(frenteModel)
        }
    }

    override suspend fun deleteAllFrente() {
        frenteDatasourceRoom.deleteAllFrente()
    }

    override suspend fun getAllFrente(): Flow<Result<List<Frente>>> {
        return flow {
            frenteDatasourceWebService.getAllFrente()
                .collect { result ->
                    result.onSuccess {frenteModelList ->
                        val frenteList = mutableListOf<Frente>()
                        for (frenteModel in frenteModelList){
                            frenteList.add(frenteModel.toFrente())
                        }
                        emit(Result.success(frenteList))
                    }
                }
        }
    }

}