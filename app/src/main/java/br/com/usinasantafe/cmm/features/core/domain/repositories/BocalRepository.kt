package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Bocal

interface BocalRepository {

    suspend fun addAllBocal(bocalList: List<Bocal>)

    suspend fun deleteAllBocal()

    suspend fun getAllBocal(): List<Bocal>

}