package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import kotlinx.coroutines.flow.Flow

interface ParadaRepository {

    suspend fun addAllParada(paradaList: List<Parada>)

    suspend fun deleteAllParada()

    suspend fun listInIdParada(idParadas: List<Long>): List<Parada>

    suspend fun recoverAllParada(): Flow<Result<List<Parada>>>

}