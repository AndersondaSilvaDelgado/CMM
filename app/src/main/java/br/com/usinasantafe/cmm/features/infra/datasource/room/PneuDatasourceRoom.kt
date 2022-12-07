package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.PneuModel

interface PneuDatasourceRoom {

    suspend fun addAllPneu(vararg pneuModels: PneuModel)

    suspend fun deleteAllPneu()

}