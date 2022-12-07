package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Atividade
import br.com.usinasantafe.cmm.features.infra.models.toAtividade
import br.com.usinasantafe.cmm.features.infra.models.toAtividadeModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtividadeRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.AtividadeDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.AtividadeDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.AtividadeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AtividadeRepositoryImpl @Inject constructor(
    private val atividadeDatasourceRoom: AtividadeDatasourceRoom,
    private val atividadeDatasourceWebService: AtividadeDatasourceWebService
): AtividadeRepository {

    override suspend fun addAllAtividade(ativList: List<Atividade>) {
        atividadeDatasourceRoom.addAllAtividade(*ativList.map { it.toAtividadeModel() }.toTypedArray())
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

    override suspend fun listInIdAtiv(idAtivs: List<Long>): List<Atividade> {
        return atividadeDatasourceRoom.listInIdAtiv(*idAtivs.toLongArray()).map { it.toAtividade() }
    }


}