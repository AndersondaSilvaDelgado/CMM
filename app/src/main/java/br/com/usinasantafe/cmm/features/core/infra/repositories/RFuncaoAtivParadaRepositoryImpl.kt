package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.RFuncaoAtivParada
import br.com.usinasantafe.cmm.features.core.infra.models.toRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.core.infra.models.toRFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.RFuncaoAtivParadaDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.RFuncaoAtivParadaDatasourceWeb
import javax.inject.Inject

class RFuncaoAtivParadaRepositoryImpl @Inject constructor(
    private val rFuncaoAtivParadaDatasourceDB: RFuncaoAtivParadaDatasourceDB,
    private val rFuncaoAtivParadaDatasourceWeb: RFuncaoAtivParadaDatasourceWeb
): RFuncaoAtivParadaRepository {

    override suspend fun addAllRFuncaoAtivParada(rFuncaoAtivParadaList: List<RFuncaoAtivParada>) {
        for(rFuncaoAtivParada in rFuncaoAtivParadaList){
            val rFuncaoAtivParadaModel = rFuncaoAtivParada.toRFuncaoAtivParadaModel()
            rFuncaoAtivParadaDatasourceDB.addRFuncaoAtivParada(rFuncaoAtivParadaModel)
        }
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDatasourceDB.deleteAllRFuncaoAtivParada()
    }

    override suspend fun getAllRFuncaoAtivParada(): List<RFuncaoAtivParada> {
        val rFuncaoAtivParadaModelList = rFuncaoAtivParadaDatasourceWeb.getAllRFuncaoAtivParada()
        val rFuncaoAtivParadaList = mutableListOf<RFuncaoAtivParada>()
        for (rFuncaoAtivParadaModel in rFuncaoAtivParadaModelList){
            rFuncaoAtivParadaList.add(rFuncaoAtivParadaModel.toRFuncaoAtivParada())
        }
        return rFuncaoAtivParadaList
    }

}