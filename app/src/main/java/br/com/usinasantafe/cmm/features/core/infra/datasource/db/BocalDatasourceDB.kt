package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.BocalModel

interface BocalDatasourceDB {

    suspend fun addBocal(bocalModel: BocalModel): Long

    suspend fun deleteAllBocal()

}