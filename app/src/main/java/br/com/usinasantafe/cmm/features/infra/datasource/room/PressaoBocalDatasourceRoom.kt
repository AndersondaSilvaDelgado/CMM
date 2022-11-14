package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.PressaoBocalModel

interface PressaoBocalDatasourceRoom {

    suspend fun addPressaoBocal(pressaoBocalModel: PressaoBocalModel): Long

    suspend fun deleteAllPressaoBocal()

}