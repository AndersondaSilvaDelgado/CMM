package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.PneuModel

interface PneuDatasourceDB {

    suspend fun addPneu(pneuModel: PneuModel): Long

    suspend fun deleteAllPneu()

}