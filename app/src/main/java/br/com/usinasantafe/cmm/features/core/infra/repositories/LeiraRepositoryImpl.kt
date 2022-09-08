package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Leira
import br.com.usinasantafe.cmm.features.core.infra.models.toLeira
import br.com.usinasantafe.cmm.features.core.infra.models.toLeiraModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.LeiraRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.LeiraDatasourceBD
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.LeiraDatasourceWeb
import javax.inject.Inject

class LeiraRepositoryImpl @Inject constructor(
    private val leiraDatasourceBD: LeiraDatasourceBD,
    private val leiraDatasourceWeb: LeiraDatasourceWeb
): LeiraRepository {

    override suspend fun addAllLeira(leiraList: List<Leira>) {
        for(leira in leiraList){
            val leiraModel = leira.toLeiraModel()
            leiraDatasourceBD.addLeira(leiraModel)
        }
    }

    override suspend fun deleteAllLeira() {
        leiraDatasourceBD.deleteAllLeira()
    }

    override suspend fun getAllLeira(): List<Leira> {
        val leiraModelList = leiraDatasourceWeb.getAllLeira()
        val leiraList = mutableListOf<Leira>()
        for (leiraModel in leiraModelList){
            leiraList.add(leiraModel.toLeira())
        }
        return leiraList
    }

}