package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Componente

interface ComponenteRepository {

    suspend fun addAllComponente(componenteList: List<Componente>)

    suspend fun deleteAllComponente()

    suspend fun getAllComponente(): List<Componente>

}