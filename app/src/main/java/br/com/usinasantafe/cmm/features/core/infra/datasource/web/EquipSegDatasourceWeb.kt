package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.EquipSegModel

interface EquipSegDatasourceWeb {

    suspend fun getAllEquipSeg(): List<EquipSegModel>

}