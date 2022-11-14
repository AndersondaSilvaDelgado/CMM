package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.AtividadeModel
import br.com.usinasantafe.cmm.features.external.room.dao.AtividadeDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.AtividadeDatasourceRoom
import javax.inject.Inject

class AtividadeDatasourceRoomImpl @Inject constructor (
    private val atividadeDao: AtividadeDao
): AtividadeDatasourceRoom {

    override suspend fun addAtividade(atividadeModel: AtividadeModel): Long {
        return atividadeDao.insert(atividadeModel)
    }

    override suspend fun deleteAllAtividade() {
        atividadeDao.deleteAll()
    }
}