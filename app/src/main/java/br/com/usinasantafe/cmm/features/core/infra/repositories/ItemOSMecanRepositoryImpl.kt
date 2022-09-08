package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.ItemOSMecan
import br.com.usinasantafe.cmm.features.core.infra.models.toItemOSMecan
import br.com.usinasantafe.cmm.features.core.infra.models.toItemOSMecanModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.ItemOSMecanRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ItemOSMecanDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ItemOSMecanDatasourceWeb
import javax.inject.Inject

class ItemOSMecanRepositoryImpl @Inject constructor(
    private val itemOSMecanDatasourceDB: ItemOSMecanDatasourceDB,
    private val itemOSMecanDatasourceWeb: ItemOSMecanDatasourceWeb
): ItemOSMecanRepository {

    override suspend fun addAllItemOSMecan(itemOSMecanList: List<ItemOSMecan>) {
        for(itemOSMecan in itemOSMecanList){
            val itemOSMecanModel = itemOSMecan.toItemOSMecanModel()
            itemOSMecanDatasourceDB.addItemOSMecan(itemOSMecanModel)
        }
    }

    override suspend fun deleteAllItemOSMecan() {
        itemOSMecanDatasourceDB.deleteAllItemOSMecan()
    }

    override suspend fun getAllItemOSMecan(): List<ItemOSMecan> {
        val itemOSMecanModelList = itemOSMecanDatasourceWeb.getAllItemOSMecan()
        val itemOSMecanList = mutableListOf<ItemOSMecan>()
        for (itemOSMecanModel in itemOSMecanModelList){
            itemOSMecanList.add(itemOSMecanModel.toItemOSMecan())
        }
        return itemOSMecanList
    }

}