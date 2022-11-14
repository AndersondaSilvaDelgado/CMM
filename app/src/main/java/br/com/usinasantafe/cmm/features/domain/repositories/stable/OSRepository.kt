package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.OS
import kotlinx.coroutines.flow.Flow

interface OSRepository {

    suspend fun addAllOS(osList: List<OS>)

    suspend fun deleteAllOS()

    suspend fun getAllOS(): Flow<Result<List<OS>>>

}