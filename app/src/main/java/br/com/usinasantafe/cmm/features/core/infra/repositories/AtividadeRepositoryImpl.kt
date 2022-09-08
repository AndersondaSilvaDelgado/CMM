package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Atividade
import br.com.usinasantafe.cmm.features.core.infra.models.toAtividade
import br.com.usinasantafe.cmm.features.core.infra.models.toAtividadeModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.AtividadeRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.AtividadeDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.AtividadeDatasourceWeb
import javax.inject.Inject

class AtividadeRepositoryImpl @Inject constructor(
    private val atividadeDatasourceDB: AtividadeDatasourceDB,
    private val atividadeDatasourceWeb: AtividadeDatasourceWeb
):AtividadeRepository {

    override suspend fun addAllAtividade(ativList: List<Atividade>) {
        for(ativ in ativList){
            val ativModel = ativ.toAtividadeModel()
            atividadeDatasourceDB.addAtividade(ativModel)
        }
    }

    override suspend fun deleteAllAtividade() {
        atividadeDatasourceDB.deleteAllAtividade()
    }

    override suspend fun getAllAtividade(): List<Atividade> {
        val ativModelList = atividadeDatasourceWeb.getAllAtividade()
        val ativList = mutableListOf<Atividade>()
        for (ativModel in ativModelList){
            ativList.add(ativModel.toAtividade())
        }
        return ativList
    }

}