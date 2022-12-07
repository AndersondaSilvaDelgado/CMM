package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.PneuModel
import br.com.usinasantafe.cmm.features.external.room.dao.PneuDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.PneuDatasourceRoom
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