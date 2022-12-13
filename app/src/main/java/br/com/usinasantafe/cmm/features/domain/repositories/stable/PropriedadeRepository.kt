package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Propriedade
import kotlinx.coroutines.flow.Flow

interface PropriedadeRepository {

    suspend fun addAllPropriedade(propriedadeList: List<Propriedade>)

    suspend fun deleteAllPropriedade()

    suspend fun recoverAllPropriedade(): Flow<Result<List<Propriedade>>>

}