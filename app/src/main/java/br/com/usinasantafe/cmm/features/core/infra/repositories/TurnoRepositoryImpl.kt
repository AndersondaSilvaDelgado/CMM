package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Turno
import br.com.usinasantafe.cmm.features.core.infra.models.toTurno
import br.com.usinasantafe.cmm.features.core.infra.models.toTurnoModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.TurnoRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.TurnoDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.TurnoDatasourceWeb
import javax.inject.Inject

class TurnoRepositoryImpl @Inject constructor(
    private val turnoDatasourceDB: TurnoDatasourceDB,
    private val turnoDatasourceWeb: TurnoDatasourceWeb
): TurnoRepository {

    override suspend fun addAllTurno(turnoList: List<Turno>) {
        for(turno in turnoList){
            val turnoModel = turno.toTurnoModel()
            turnoDatasourceDB.addTurno(turnoModel)
        }
    }

    override suspend fun deleteAllTurno() {
        turnoDatasourceDB.deleteAllTurno()
    }

    override suspend fun getAllTurno(): List<Turno> {
        val turnoModelList = turnoDatasourceWeb.getAllTurno()
        val turnoList = mutableListOf<Turno>()
        for (turnoModel in turnoModelList){
            turnoList.add(turnoModel.toTurno())
        }
        return turnoList
    }

}


