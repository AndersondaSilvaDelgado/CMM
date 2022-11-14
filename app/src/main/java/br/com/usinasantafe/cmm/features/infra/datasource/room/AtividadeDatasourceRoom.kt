package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.AtividadeModel

interface AtividadeDatasourceRoom {

    suspend fun addAtividade(atividadeModel: AtividadeModel): Long

    suspend fun deleteAllAtividade()

}