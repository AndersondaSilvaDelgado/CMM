package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.LeiraModel

interface LeiraDatasourceBD {

    suspend fun addLeira(leiraModel: LeiraModel): Long

    suspend fun deleteAllLeira()

}