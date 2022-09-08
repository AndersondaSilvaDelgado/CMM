package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.RFuncaoAtivParada

interface RFuncaoAtivParadaRepository {

    suspend fun addAllRFuncaoAtivParada(rFuncaoAtivParadaList: List<RFuncaoAtivParada>)

    suspend fun deleteAllRFuncaoAtivParada()

    suspend fun getAllRFuncaoAtivParada(): List<RFuncaoAtivParada>

}