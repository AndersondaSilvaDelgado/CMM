package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Propriedade
import kotlinx.coroutines.flow.Flow

interface PropriedadeRepository {

    suspend fun addAllPropriedade(propriedadeList: List<Propriedade>)

    suspend fun deleteAllPropriedade()

    suspend fun getAllPropriedade(): Flow<Result<List<Propriedade>>>

}