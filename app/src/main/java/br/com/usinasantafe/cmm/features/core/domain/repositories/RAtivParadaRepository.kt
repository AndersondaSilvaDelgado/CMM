package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.RAtivParada

interface RAtivParadaRepository {

    suspend fun addAllRAtivParada(rAtivParadaList: List<RAtivParada>)

    suspend fun deleteAllRAtivParada()

    suspend fun getAllRAtivParada(): List<RAtivParada>

}