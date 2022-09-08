package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.EquipSeg
import br.com.usinasantafe.cmm.features.core.infra.models.toEquipSeg
import br.com.usinasantafe.cmm.features.core.infra.models.toEquipSegModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.EquipSegRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.EquipSegDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.EquipSegDatasourceWeb
import javax.inject.Inject

class EquipSegRepositoryImpl @Inject constructor(
    private val equipSegDatasourceDB: EquipSegDatasourceDB,
    private val equipSegDatasourceWeb: EquipSegDatasourceWeb
): EquipSegRepository {

    override suspend fun addAllEquipSeg(equipSegList: List<EquipSeg>) {
        for(equipSeg in equipSegList){
            val equipSegModel = equipSeg.toEquipSegModel()
            equipSegDatasourceDB.addEquipSeg(equipSegModel)
        }
    }

    override suspend fun deleteAllEquipSeg() {
        equipSegDatasourceDB.deleteAllEquipSeg()
    }

    override suspend fun getAllEquipSeg(): List<EquipSeg> {
        val equipSegModelList = equipSegDatasourceWeb.getAllEquipSeg()
        val equipSegList = mutableListOf<EquipSeg>()
        for (equipSegModel in equipSegModelList){
            equipSegList.add(equipSegModel.toEquipSeg())
        }
        return equipSegList
    }

}