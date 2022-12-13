package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.RAtivParada
import kotlinx.coroutines.flow.Flow

interface RAtivParadaRepository {

    suspend fun addAllRAtivParada(rAtivParadaList: List<RAtivParada>)

    suspend fun deleteAllRAtivParada()

    suspend fun recoverAllRAtivParada(): Flow<Result<List<RAtivParada>>>

}