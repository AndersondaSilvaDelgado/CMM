package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Parada
import br.com.usinasantafe.cmm.features.core.infra.models.toParada
import br.com.usinasantafe.cmm.features.core.infra.models.toParadaModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.ParadaRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ParadaDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ParadaDatasourceWeb
import javax.inject.Inject

class ParadaRepositoryImpl @Inject constructor(
    private val paradaDatasourceDB: ParadaDatasourceDB,
    private val paradaDatasourceWeb: ParadaDatasourceWeb
): ParadaRepository {

    override suspend fun addAllParada(paradaList: List<Parada>) {
        for(parada in paradaList){
            val paradaModel = parada.toParadaModel()
            paradaDatasourceDB.addParada(paradaModel)
        }
    }

    override suspend fun deleteAllParada() {
        paradaDatasourceDB.deleteAllParada()
    }

    override suspend fun getAllParada(): List<Parada> {
        val paradaModelList = paradaDatasourceWeb.getAllParada()
        val paradaList = mutableListOf<Parada>()
        for (paradaModel in paradaModelList){
            paradaList.add(paradaModel.toParada())
        }
        return paradaList
    }

}