package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Func

interface FuncRepository {

    suspend fun addAllFunc(funcList: List<Func>)

    suspend fun deleteAllFunc()

    suspend fun getAllFunc(): List<Func>

}