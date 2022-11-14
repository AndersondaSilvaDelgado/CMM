package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Atividade
import br.com.usinasantafe.cmm.features.infra.models.toAtividade
import br.com.usinasantafe.cmm.features.infra.models.toAtividadeModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtividadeRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.AtividadeDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.AtividadeDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AtividadeRepositoryImpl @Inject constructor(
    private val atividadeDatasourceRoom: AtividadeDatasourceRoom,
    private val atividadeDatasourceWebService: AtividadeDatasourceWebService
): AtividadeRepository {

    override suspend fun addAllAtividade(ativList: List<Atividade>) {
        for(ativ in ativList){
            val ativModel = ativ.toAtividadeModel()
            atividadeDatasourceRoom.addAtividade(ativModel)
        }
    }

    override suspend fun deleteAllAtividade() {
        atividadeDatasourceRoom.deleteAllAtividade()
    }

    override suspend fun getAllAtividade(): Flow<Result<List<Atividade>>> {
        return flow {
            atividadeDatasourceWebService.getAllAtividade()
                .collect { result ->
                    result.onSuccess { atividadeModelList ->
                        val ativList = mutableListOf<Atividade>()
                        for (ativModel in atividadeModelList){
                            ativList.add(ativModel.toAtividade())
                        }
                        emit(Result.success(ativList))
                    }
                }
            }
    }

}