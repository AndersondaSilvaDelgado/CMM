package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ServicoModel

interface ServicoDatasourceRoom {

    suspend fun addServico(servicoModel: ServicoModel): Long

    suspend fun deleteAllServico()

}