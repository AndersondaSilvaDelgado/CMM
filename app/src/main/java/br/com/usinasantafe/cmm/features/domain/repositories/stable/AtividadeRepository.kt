package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Atividade
import kotlinx.coroutines.flow.Flow

interface AtividadeRepository {

    suspend fun addAllAtividade(atividadeList: List<Atividade>)

    suspend fun deleteAllAtividade()

    suspend fun getAllAtividade(): Flow<Result<List<Atividade>>>

}