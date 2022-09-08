package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Bocal
import br.com.usinasantafe.cmm.features.core.infra.models.toBocal
import br.com.usinasantafe.cmm.features.core.infra.models.toBocalModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.BocalRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.BocalDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.BocalDatasourceWeb
import javax.inject.Inject

class BocalRepositoryImpl @Inject constructor(
    private val bocalDatasourceDB: BocalDatasourceDB,
    private val bocalDatasourceWeb: BocalDatasourceWeb
): BocalRepository {

    override suspend fun addAllBocal(bocalList: List<Bocal>) {
        for(bocal in bocalList){
            val bocalModel = bocal.toBocalModel()
            bocalDatasourceDB.addBocal(bocalModel)
        }
    }

    override suspend fun deleteAllBocal() {
        bocalDatasourceDB.deleteAllBocal()
    }

    override suspend fun getAllBocal(): List<Bocal> {
        val bocalModelList = bocalDatasourceWeb.getAllBocal()
        val bocalList = mutableListOf<Bocal>()
        for (bocalModel in bocalModelList){
            bocalList.add(bocalModel.toBocal())
        }
        return bocalList
    }

}