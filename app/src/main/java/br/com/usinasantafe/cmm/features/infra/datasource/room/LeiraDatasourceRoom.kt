package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.LeiraModel

interface LeiraDatasourceRoom {

    suspend fun addLeira(leiraModel: LeiraModel): Long

    suspend fun deleteAllLeira()

}