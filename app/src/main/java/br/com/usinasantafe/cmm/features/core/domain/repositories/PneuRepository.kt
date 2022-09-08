package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Pneu

interface PneuRepository {

    suspend fun addAllPneu(pneuList: List<Pneu>)

    suspend fun deleteAllPneu()

    suspend fun getAllPneu(): List<Pneu>
}