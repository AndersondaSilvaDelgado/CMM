package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.MotoMec
import kotlinx.coroutines.flow.Flow

interface MotoMecRepository {

    suspend fun addAllMotoMec(motoMecList: List<MotoMec>)

    suspend fun deleteAllMotoMec()

    suspend fun getAllMotoMec(): Flow<Result<List<MotoMec>>>

}