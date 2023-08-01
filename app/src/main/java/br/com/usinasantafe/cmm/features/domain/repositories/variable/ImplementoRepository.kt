package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.variable.Implemento

interface ImplementoRepository {

    suspend fun addImplemento(nroEquip: Long): Boolean

    suspend fun clearData()

    suspend fun countImplemento(): Int

    suspend fun listImplemento(): List<Implemento>

}