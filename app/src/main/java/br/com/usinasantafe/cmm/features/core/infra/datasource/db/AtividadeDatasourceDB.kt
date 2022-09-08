package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.AtividadeModel

interface AtividadeDatasourceDB {

    suspend fun addAtividade(atividadeModel: AtividadeModel): Long

    suspend fun deleteAllAtividade()

}