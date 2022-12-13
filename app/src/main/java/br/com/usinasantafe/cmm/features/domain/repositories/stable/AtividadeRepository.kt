package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade
import kotlinx.coroutines.flow.Flow

interface AtividadeRepository {

    suspend fun addAllAtividade(atividadeList: List<Atividade>)

    suspend fun deleteAllAtividade()

    suspend fun recoverAllAtividade(): Flow<Result<List<Atividade>>>

    suspend fun listInIdAtiv(idAtivs: List<Long>): List<Atividade>

}