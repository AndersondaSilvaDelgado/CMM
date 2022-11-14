package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Func
import kotlinx.coroutines.flow.Flow

interface FuncRepository {

    suspend fun addAllFunc(funcList: List<Func>)

    suspend fun deleteAllFunc()

    suspend fun getAllFunc(): Flow<Result<List<Func>>>

    suspend fun checkFuncNro(nroFunc: String): Boolean

}