package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Propriedade
import br.com.usinasantafe.cmm.features.core.infra.models.toPropriedade
import br.com.usinasantafe.cmm.features.core.infra.models.toPropriedadeModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.PropriedadeRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.PropriedadeDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.PropriedadeDatasourceWeb
import javax.inject.Inject

class PropriedadeRepositoryImpl @Inject constructor(
    private val propriedadeDatasourceDB: PropriedadeDatasourceDB,
    private val propriedadeDatasourceWeb: PropriedadeDatasourceWeb
): PropriedadeRepository {

    override suspend fun addAllPropriedade(propriedadeList: List<Propriedade>) {
        for(propriedade in propriedadeList){
            val propriedadeModel = propriedade.toPropriedadeModel()
            propriedadeDatasourceDB.addPropriedade(propriedadeModel)
        }
    }

    override suspend fun deleteAllPropriedade() {
        propriedadeDatasourceDB.deleteAllPropriedade()
    }

    override suspend fun getAllPropriedade(): List<Propriedade> {
        val propriedadeModelList = propriedadeDatasourceWeb.getAllPropriedade()
        val propriedadeList = mutableListOf<Propriedade>()
        for (propriedadeModel in propriedadeModelList){
            propriedadeList.add(propriedadeModel.toPropriedade())
        }
        return propriedadeList
    }

}