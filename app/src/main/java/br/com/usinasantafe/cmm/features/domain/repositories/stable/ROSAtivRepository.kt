package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.ROSAtiv
import kotlinx.coroutines.flow.Flow

interface ROSAtivRepository {

    suspend fun addAllROSAtiv(rOSAtivList: List<ROSAtiv>)

    suspend fun deleteAllROSAtiv()

    suspend fun recoverAllROSAtiv(): Flow<Result<List<ROSAtiv>>>

    suspend fun recoverROSAtiv(nroOS: String): Flow<Result<List<ROSAtiv>>>

    suspend fun listROSAtiv(idOS: Long): List<ROSAtiv>

}