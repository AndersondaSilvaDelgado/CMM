package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.ItemOSMecanModel

interface ItemOSMecanDatasourceWeb {

    suspend fun getAllItemOSMecan(): List<ItemOSMecanModel>

}