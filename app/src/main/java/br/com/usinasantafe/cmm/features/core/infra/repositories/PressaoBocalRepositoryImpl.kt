package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.PressaoBocal
import br.com.usinasantafe.cmm.features.core.infra.models.toPressaoBocal
import br.com.usinasantafe.cmm.features.core.infra.models.toPressaoBocalModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.PressaoBocalRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.PressaoBocalDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.PressaoBocalDatasourceWeb
import javax.inject.Inject

class PressaoBocalRepositoryImpl @Inject constructor(
    private val pressaoBocalDatasourceDB: PressaoBocalDatasourceDB,
    private val pressaoBocalDatasourceWeb: PressaoBocalDatasourceWeb
): PressaoBocalRepository {

    override suspend fun addAllPressaoBocal(pressaoBocalList: List<PressaoBocal>) {
        for(pressaoBocal in pressaoBocalList){
            val pressaoBocalModel = pressaoBocal.toPressaoBocalModel()
            pressaoBocalDatasourceDB.addPressaoBocal(pressaoBocalModel)
        }
    }

    override suspend fun deleteAllPressaoBocal() {
        pressaoBocalDatasourceDB.deleteAllPressaoBocal()
    }

    override suspend fun getAllPressaoBocal(): List<PressaoBocal> {
        val pressaoBocalModelList = pressaoBocalDatasourceWeb.getAllPressaoBocal()
        val pressaoBocalList = mutableListOf<PressaoBocal>()
        for (pressaoBocalModel in pressaoBocalModelList){
            pressaoBocalList.add(pressaoBocalModel.toPressaoBocal())
        }
        return pressaoBocalList
    }

}