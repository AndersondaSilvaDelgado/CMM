package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.ROSAtiv
import kotlinx.coroutines.flow.Flow

interface ROSAtivRepository {

    suspend fun addAllROSAtiv(rOSAtivList: List<ROSAtiv>)

    suspend fun deleteAllROSAtiv()

    suspend fun getAllROSAtiv(): Flow<Result<List<ROSAtiv>>>

}