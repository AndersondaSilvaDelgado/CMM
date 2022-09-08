package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Parada

interface ParadaRepository {

    suspend fun addAllParada(paradaList: List<Parada>)

    suspend fun deleteAllParada()

    suspend fun getAllParada(): List<Parada>

}