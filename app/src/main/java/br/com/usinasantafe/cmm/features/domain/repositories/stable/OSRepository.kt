package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.OS
import kotlinx.coroutines.flow.Flow

interface OSRepository {

    suspend fun addAllOS(osList: List<OS>)

    suspend fun deleteAllOS()

    suspend fun recoverAllOS(): Flow<Result<List<OS>>>

    suspend fun recoverOS(nroOS: String): Flow<Result<List<OS>>>

    suspend fun checkOS(nroOS: String): Boolean

    suspend fun getOSNro(nroOS: Long): OS

}