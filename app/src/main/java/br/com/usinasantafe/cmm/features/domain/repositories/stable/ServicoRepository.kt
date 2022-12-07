package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Servico
import kotlinx.coroutines.flow.Flow

interface ServicoRepository {

    suspend fun addAllServico(servicoList: List<Servico>)

    suspend fun deleteAllServico()

    suspend fun recoverAllServico(): Flow<Result<List<Servico>>>

}