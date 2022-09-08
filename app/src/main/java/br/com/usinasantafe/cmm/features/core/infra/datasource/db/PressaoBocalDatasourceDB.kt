package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.PressaoBocalModel

interface PressaoBocalDatasourceDB {

    suspend fun addPressaoBocal(pressaoBocalModel: PressaoBocalModel): Long

    suspend fun deleteAllPressaoBocal()

}