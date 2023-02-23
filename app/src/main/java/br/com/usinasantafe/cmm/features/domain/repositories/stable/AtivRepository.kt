package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import kotlinx.coroutines.flow.Flow

interface AtivRepository {

    suspend fun addAllAtiv(ativList: List<Ativ>)

    suspend fun deleteAllAtiv()

    suspend fun listInIdAtiv(idAtivs: List<Long>): List<Ativ>

    suspend fun recoverAllAtiv(): Flow<Result<List<Ativ>>>

}