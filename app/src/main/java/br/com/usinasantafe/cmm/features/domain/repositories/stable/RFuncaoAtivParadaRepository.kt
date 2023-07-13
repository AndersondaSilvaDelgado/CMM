package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.RFuncaoAtivParada
import kotlinx.coroutines.flow.Flow

interface RFuncaoAtivParadaRepository {

    suspend fun addAllRFuncaoAtivParada(rFuncaoAtivParadaList: List<RFuncaoAtivParada>)

    suspend fun deleteAllRFuncaoAtivParada()

    suspend fun listRFuncaoAtiv(): List<RFuncaoAtivParada>

    suspend fun getParadaCheckList(): RFuncaoAtivParada

    suspend fun recoverAllRFuncaoAtivParada(): Flow<Result<List<RFuncaoAtivParada>>>

}