package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Frente
import br.com.usinasantafe.cmm.features.core.infra.models.toFrente
import br.com.usinasantafe.cmm.features.core.infra.models.toFrenteModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.FrenteRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.FrenteDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.FrenteDatasourceWeb
import javax.inject.Inject

class FrenteRepositoryImpl @Inject constructor(
    private val frenteDatasourceDB: FrenteDatasourceDB,
    private val frenteDatasourceWeb: FrenteDatasourceWeb
): FrenteRepository {

    override suspend fun addAllFrente(frenteList: List<Frente>) {
        for(frente in frenteList){
            val frenteModel = frente.toFrenteModel()
            frenteDatasourceDB.addFrente(frenteModel)
        }
    }

    override suspend fun deleteAllFrente() {
        frenteDatasourceDB.deleteAllFrente()
    }

    override suspend fun getAllFrente(): List<Frente> {
        val frenteModelList = frenteDatasourceWeb.getAllFrente()
        val frenteList = mutableListOf<Frente>()
        for (frenteModel in frenteModelList){
            frenteList.add(frenteModel.toFrente())
        }
        return frenteList
    }

}