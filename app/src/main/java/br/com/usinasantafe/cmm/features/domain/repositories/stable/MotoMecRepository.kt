package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.MotoMec
import kotlinx.coroutines.flow.Flow

interface MotoMecRepository {

    suspend fun addAllMotoMec(motoMecList: List<MotoMec>)

    suspend fun deleteAllMotoMec()

    suspend fun recoverAllMotoMec(): Flow<Result<List<MotoMec>>>

}