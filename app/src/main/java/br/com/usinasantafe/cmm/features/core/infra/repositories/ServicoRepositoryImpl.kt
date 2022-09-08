package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Servico
import br.com.usinasantafe.cmm.features.core.infra.models.toServico
import br.com.usinasantafe.cmm.features.core.infra.models.toServicoModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.ServicoRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ServicoDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ServicoDatasourceWeb
import javax.inject.Inject

class ServicoRepositoryImpl @Inject constructor(
    private val servicoDatasourceDB: ServicoDatasourceDB,
    private val servicoDatasourceWeb: ServicoDatasourceWeb
): ServicoRepository {

    override suspend fun addAllServico(servicoList: List<Servico>) {
        for(servico in servicoList){
            val servicoModel = servico.toServicoModel()
            servicoDatasourceDB.addServico(servicoModel)
        }
    }

    override suspend fun deleteAllServico() {
        servicoDatasourceDB.deleteAllServico()
    }

    override suspend fun getAllServico(): List<Servico> {
        val servicoModelList = servicoDatasourceWeb.getAllServico()
        val servicoList = mutableListOf<Servico>()
        for (servicoModel in servicoModelList){
            servicoList.add(servicoModel.toServico())
        }
        return servicoList
    }

}