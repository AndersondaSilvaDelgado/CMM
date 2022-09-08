package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ServicoModel

interface ServicoDatasourceDB {

    suspend fun addServico(servicoModel: ServicoModel): Long

    suspend fun deleteAllServico()

}