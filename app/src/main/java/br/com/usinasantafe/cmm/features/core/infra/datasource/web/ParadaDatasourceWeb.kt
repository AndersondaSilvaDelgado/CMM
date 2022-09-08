package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.ParadaModel

interface ParadaDatasourceWeb {

    suspend fun getAllParada(): List<ParadaModel>

}