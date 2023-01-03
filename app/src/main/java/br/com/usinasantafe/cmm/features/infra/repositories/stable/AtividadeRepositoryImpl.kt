package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade
import br.com.usinasantafe.cmm.features.infra.models.stable.toAtividade
import br.com.usinasantafe.cmm.features.infra.models.stable.toAtividadeModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtividadeRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.AtividadeDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.AtividadeDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AtividadeRepositoryImpl @Inject constructor(
    private val atividadeDatasourceRoom: AtividadeDatasourceRoom,
    private val atividadeDatasourceWebService: AtividadeDatasourceWebService
): AtividadeRepository {

    override suspend fun addAllAtividade(atividadeList: List<Atividade>) {
        atividadeDatasourceRoom.addAllAtividade(*atividadeList.map { it.toAtividadeModel() }.toTypedArray())
    }

    override suspend fun deleteAllAtividade() {
        atividadeDatasourceRoom.deleteAllAtividade()
    }

    override suspend fun recoverAllAtividade(): Flow<Result<List<Atividade>>> {
        return flow {
            atividadeDatasourceWebService.getAllAtividade()
                .collect { result ->
                    result.onSuccess { atividadeModelList ->
                        emit(Result.success(atividadeModelList.map { it.toAtividade() }))
                    }
                }
            }
    }

    override suspend fun listInIdAtiv(idAtividades: List<Long>): List<Atividade> {
        return atividadeDatasourceRoom.listInIdAtiv(*idAtividades.toLongArray()).map { it.toAtividade() }
    }
    
}