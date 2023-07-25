package br.com.usinasantafe.cmm.features.domain.repositories.variable

interface ImplementoRepository {

    suspend fun addImplemento(nroEquip: Long): Boolean

    suspend fun clearData()

    suspend fun countImplemento(): Int

}