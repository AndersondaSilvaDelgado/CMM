package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.PneuModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.PneuDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.PneuDatasourceRoom
import javax.inject.Inject

class PneuDatasourceRoomImpl @Inject constructor(
    private val pneuDao: PneuDao
): PneuDatasourceRoom {

    override suspend fun addAllPneu(vararg pneuModels: PneuModel) {
        pneuDao.insertAll(*pneuModels)
    }

    override suspend fun deleteAllPneu() {
        pneuDao.deleteAll()
    }
}