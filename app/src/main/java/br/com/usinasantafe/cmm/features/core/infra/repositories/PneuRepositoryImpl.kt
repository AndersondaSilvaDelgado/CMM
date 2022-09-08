package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Pneu
import br.com.usinasantafe.cmm.features.core.infra.models.toPneu
import br.com.usinasantafe.cmm.features.core.infra.models.toPneuModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.PneuRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.PneuDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.PneuDatasourceWeb
import javax.inject.Inject

class PneuRepositoryImpl @Inject constructor(
    private val pneuDatasourceDB: PneuDatasourceDB,
    private val pneuDatasourceWeb: PneuDatasourceWeb
): PneuRepository{

    override suspend fun addAllPneu(pneuList: List<Pneu>) {
        for(pneu in pneuList){
            val pneuModel = pneu.toPneuModel()
            pneuDatasourceDB.addPneu(pneuModel)
        }
    }

    override suspend fun deleteAllPneu() {
        pneuDatasourceDB.deleteAllPneu()
    }

    override suspend fun getAllPneu(): List<Pneu> {
        val pneuModelList = pneuDatasourceWeb.getAllPneu()
        val pneuList = mutableListOf<Pneu>()
        for (pneuModel in pneuModelList){
            pneuList.add(pneuModel.toPneu())
        }
        return pneuList
    }

}