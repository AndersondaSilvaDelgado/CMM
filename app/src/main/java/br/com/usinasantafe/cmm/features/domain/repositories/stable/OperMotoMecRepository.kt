package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.OperMotoMec
import kotlinx.coroutines.flow.Flow

interface OperMotoMecRepository {

    suspend fun addAllOperMotoMec(operMotoMecList: List<OperMotoMec>)

    suspend fun deleteAllOperMotoMec()

    suspend fun recoverAllOperMotoMec(): Flow<Result<List<OperMotoMec>>>

}