package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Frente
import kotlinx.coroutines.flow.Flow

interface FrenteRepository {

    suspend fun addAllFrente(frenteList: List<Frente>)

    suspend fun deleteAllFrente()

    suspend fun getAllFrente(): Flow<Result<List<Frente>>>

}