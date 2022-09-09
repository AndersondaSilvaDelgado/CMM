package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.TurnoModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.TurnoDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.TurnoDatasourceDB
import javax.inject.Inject

class TurnoDatasourceDBImpl @Inject constructor (
    private val turnoDao: TurnoDao
): TurnoDatasourceDB {

    override suspend fun addTurno(turnoModel: TurnoModel): Long {
        return turnoDao.insert(turnoModel)
    }

    override suspend fun deleteAllTurno() {
        turnoDao.deleteAll()
    }

}