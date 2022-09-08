package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.RAtivParada
import br.com.usinasantafe.cmm.features.core.infra.models.toRAtivParada
import br.com.usinasantafe.cmm.features.core.infra.models.toRAtivParadaModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.RAtivParadaRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.RAtivParadaDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.RAtivParadaDatasourceWeb
import javax.inject.Inject

class RAtivParadaRepositoryImpl @Inject constructor(
    private val rAtivParadaDatasourceDB: RAtivParadaDatasourceDB,
    private val rAtivParadaDatasourceWeb: RAtivParadaDatasourceWeb
): RAtivParadaRepository {

    override suspend fun addAllRAtivParada(rAtivParadaList: List<RAtivParada>) {
        for(rAtivParada in rAtivParadaList){
            val rAtivParadaModel = rAtivParada.toRAtivParadaModel()
            rAtivParadaDatasourceDB.addRAtivParada(rAtivParadaModel)
        }
    }

    override suspend fun deleteAllRAtivParada() {
        rAtivParadaDatasourceDB.deleteAllRAtivParada()
    }

    override suspend fun getAllRAtivParada(): List<RAtivParada> {
        val rAtivParadaModelList = rAtivParadaDatasourceWeb.getAllRAtivParada()
        val rAtivParadaList = mutableListOf<RAtivParada>()
        for (rAtivParadaModel in rAtivParadaModelList){
            rAtivParadaList.add(rAtivParadaModel.toRAtivParada())
        }
        return rAtivParadaList
    }

}