package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Frente

interface FrenteRepository {

    suspend fun addAllFrente(frenteList: List<Frente>)

    suspend fun deleteAllFrente()

    suspend fun getAllFrente(): List<Frente>

}