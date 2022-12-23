package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.TurnoModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.TurnoDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.TurnoDatasourceRoom
import javax.inject.Inject

class TurnoDatasourceRoomImpl @Inject constructor (
    private val turnoDao: TurnoDao
): TurnoDatasourceRoom {

    override suspend fun addAllTurno(vararg turnoModels: TurnoModel) {
        turnoDao.insertAll(*turnoModels)
    }

    override suspend fun deleteAllTurno() {
        turnoDao.deleteAll()
    }

    override suspend fun hasTurno(): Boolean {
        return (turnoDao.count() > 0)
    }

    override suspend fun listTurno(codTurno: Long): List<TurnoModel> {
        return turnoDao.listCod(codTurno)
    }

}