package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Atividade

interface AtividadeRepository {

    suspend fun addAllAtividade(atividadeList: List<Atividade>)

    suspend fun deleteAllAtividade()

    suspend fun getAllAtividade(): List<Atividade>

}