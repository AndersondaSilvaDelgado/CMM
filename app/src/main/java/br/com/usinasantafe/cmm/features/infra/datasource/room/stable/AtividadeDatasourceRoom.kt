package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.AtividadeModel

interface AtividadeDatasourceRoom {

    suspend fun addAllAtividade(vararg atividadeModels: AtividadeModel)

    suspend fun deleteAllAtividade()

    suspend fun listInIdAtiv(vararg idAtivs: Long): List<AtividadeModel>

}