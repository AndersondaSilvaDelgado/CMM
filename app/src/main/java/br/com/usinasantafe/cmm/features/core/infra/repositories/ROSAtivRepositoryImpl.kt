package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.ROSAtiv
import br.com.usinasantafe.cmm.features.core.infra.models.toROSAtiv
import br.com.usinasantafe.cmm.features.core.infra.models.toROSAtivModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.ROSAtivRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ROSAtivDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ROSAtivDatasourceWeb
import javax.inject.Inject

class ROSAtivRepositoryImpl @Inject constructor(
    private val rOSAtivDatasourceDB: ROSAtivDatasourceDB,
    private val rOSAtivDatasourceWeb: ROSAtivDatasourceWeb
): ROSAtivRepository {

    override suspend fun addAllROSAtiv(rOSAtivList: List<ROSAtiv>) {
        for(rOSAtiv in rOSAtivList){
            val rOSAtivModel = rOSAtiv.toROSAtivModel()
            rOSAtivDatasourceDB.addROSAtiv(rOSAtivModel)
        }
    }

    override suspend fun deleteAllROSAtiv() {
        rOSAtivDatasourceDB.deleteAllROSAtiv()
    }

    override suspend fun getAllROSAtiv(): List<ROSAtiv> {
        val rOSAtivModelList = rOSAtivDatasourceWeb.getAllROSAtiv()
        val rOSAtivList = mutableListOf<ROSAtiv>()
        for (rOSAtivModel in rOSAtivModelList){
            rOSAtivList.add(rOSAtivModel.toROSAtiv())
        }
        return rOSAtivList
    }

}