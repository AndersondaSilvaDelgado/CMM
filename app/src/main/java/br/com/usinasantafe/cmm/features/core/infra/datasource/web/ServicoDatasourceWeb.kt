package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.ServicoModel

interface ServicoDatasourceWeb {

    suspend fun getAllServico(): List<ServicoModel>

}