package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Componente
import kotlinx.coroutines.flow.Flow

interface ComponenteRepository {

    suspend fun addAllComponente(componenteList: List<Componente>)

    suspend fun deleteAllComponente()

    suspend fun recoverAllComponente(): Flow<Result<List<Componente>>>

}