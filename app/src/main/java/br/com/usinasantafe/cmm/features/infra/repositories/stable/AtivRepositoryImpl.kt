package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.features.infra.models.stable.toAtividade
import br.com.usinasantafe.cmm.features.infra.models.stable.toAtividadeModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtivRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.AtividadeDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.AtividadeDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AtivRepositoryImpl @Inject constructor(
    private val atividadeDatasourceRoom: AtividadeDatasourceRoom,
    private val atividadeDatasourceWebService: AtividadeDatasourceWebService
): AtivRepository {

    override suspend fun addAllAtiv(ativList: List<Ativ>) {
        atividadeDatasourceRoom.addAllAtividade(*ativList.map { it.toAtividadeModel() }.toTypedArray())
    }

    override suspend fun deleteAllAtiv() {
        atividadeDatasourceRoom.deleteAllAtividade()
    }

    override suspend fun listInIdAtiv(idAtivs: List<Long>): List<Ativ> {
        return atividadeDatasourceRoom.listInIdAtiv(*idAtivs.toLongArray()).map { it.toAtividade() }
    }

    override suspend fun recoverAllAtiv(): Flow<Result<List<Ativ>>> {
        return flow {
            atividadeDatasourceWebService.getAllAtividade()
                .collect { result ->
                    result.onSuccess { atividadeModelList ->
                        emit(Result.success(atividadeModelList.map { it.toAtividade() }))
                    }
                }
            }
    }

}