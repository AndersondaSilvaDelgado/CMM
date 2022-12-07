package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Parada
import kotlinx.coroutines.flow.Flow

interface ParadaRepository {

    suspend fun addAllParada(paradaList: List<Parada>)

    suspend fun deleteAllParada()

    suspend fun recoverAllParada(): Flow<Result<List<Parada>>>

}