package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Servico

interface ServicoRepository {

    suspend fun addAllServico(servicoList: List<Servico>)

    suspend fun deleteAllServico()

    suspend fun getAllServico(): List<Servico>

}