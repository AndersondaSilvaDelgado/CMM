package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.ItemCheckListModel

interface ItemCheckListDatasourceWeb {

    suspend fun getAllItemCheckList(): List<ItemCheckListModel>

}