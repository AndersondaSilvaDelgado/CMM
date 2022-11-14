package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.PressaoBocalModel
import br.com.usinasantafe.cmm.features.external.room.dao.PressaoBocalDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.PressaoBocalDatasourceRoom
import javax.inject.Inject

class PressaoBocalDatasourceRoomImpl @Inject constructor (
    private val pressaoBocalDao: PressaoBocalDao
): PressaoBocalDatasourceRoom {

    override suspend fun addPressaoBocal(pressaoBocalModel: PressaoBocalModel): Long {
        return pressaoBocalDao.insert(pressaoBocalModel)
    }

    override suspend fun deleteAllPressaoBocal() {
        pressaoBocalDao.deleteAll()
    }

}