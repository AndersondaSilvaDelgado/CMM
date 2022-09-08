package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.PressaoBocal

interface PressaoBocalRepository {

    suspend fun addAllPressaoBocal(pressaoBocalList: List<PressaoBocal>)

    suspend fun deleteAllPressaoBocal()

    suspend fun getAllPressaoBocal(): List<PressaoBocal>

}