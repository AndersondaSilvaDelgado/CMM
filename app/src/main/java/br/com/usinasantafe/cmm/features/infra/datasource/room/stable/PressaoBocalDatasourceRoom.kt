package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.PressaoBocalModel

interface PressaoBocalDatasourceRoom {

    suspend fun addAllPressaoBocal(vararg pressaoBocalModels: PressaoBocalModel)

    suspend fun deleteAllPressaoBocal()

}