package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ServicoModel

interface ServicoDatasourceRoom {

    suspend fun addAllServico(vararg servicoModels: ServicoModel)

    suspend fun deleteAllServico()

}