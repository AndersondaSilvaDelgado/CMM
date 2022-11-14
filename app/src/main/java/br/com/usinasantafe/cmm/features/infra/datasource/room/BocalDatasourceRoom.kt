package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.BocalModel

interface BocalDatasourceRoom {

    suspend fun addBocal(bocalModel: BocalModel): Long

    suspend fun deleteAllBocal()

}