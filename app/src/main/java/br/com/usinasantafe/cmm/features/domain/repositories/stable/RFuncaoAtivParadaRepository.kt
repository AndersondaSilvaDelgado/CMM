package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.RFuncaoAtivParada
import kotlinx.coroutines.flow.Flow

interface RFuncaoAtivParadaRepository {

    suspend fun addAllRFuncaoAtivParada(rFuncaoAtivParadaList: List<RFuncaoAtivParada>)

    suspend fun deleteAllRFuncaoAtivParada()

    suspend fun getAllRFuncaoAtivParada(): Flow<Result<List<RFuncaoAtivParada>>>

}