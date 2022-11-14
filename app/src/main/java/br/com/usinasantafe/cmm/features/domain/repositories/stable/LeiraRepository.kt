package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Leira
import kotlinx.coroutines.flow.Flow

interface LeiraRepository {

    suspend fun addAllLeira(leiraList: List<Leira>)

    suspend fun deleteAllLeira()

    suspend fun getAllLeira(): Flow<Result<List<Leira>>>

}