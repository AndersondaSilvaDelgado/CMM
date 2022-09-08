package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Leira

interface LeiraRepository {

    suspend fun addAllLeira(leiraList: List<Leira>)

    suspend fun deleteAllLeira()

    suspend fun getAllLeira(): List<Leira>

}