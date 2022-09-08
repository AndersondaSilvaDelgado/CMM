package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.OS
import br.com.usinasantafe.cmm.features.core.infra.models.toOS
import br.com.usinasantafe.cmm.features.core.infra.models.toOSModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.OSRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.OSDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.OSDatasourceWeb
import javax.inject.Inject

class OSRepositoryImpl @Inject constructor(
    private val osDatasourceDB: OSDatasourceDB,
    private val osDatasourceWeb: OSDatasourceWeb
): OSRepository {

    override suspend fun addAllOS(osList: List<OS>) {
        for(os in osList){
            val osModel = os.toOSModel()
            osDatasourceDB.addOS(osModel)
        }
    }

    override suspend fun deleteAllOS() {
        osDatasourceDB.deleteAllOS()
    }

    override suspend fun getAllOS(): List<OS> {
        val osModelList = osDatasourceWeb.getAllOS()
        val osList = mutableListOf<OS>()
        for (osModel in osModelList){
            osList.add(osModel.toOS())
        }
        return osList
    }

}