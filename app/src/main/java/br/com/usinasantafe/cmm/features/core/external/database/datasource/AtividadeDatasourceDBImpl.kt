package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.AtividadeModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.AtividadeDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.AtividadeDatasourceDB
import javax.inject.Inject

class AtividadeDatasourceDBImpl @Inject constructor (
    private val atividadeDao: AtividadeDao
): AtividadeDatasourceDB {

    override suspend fun addAtividade(atividadeModel: AtividadeModel): Long {
        return atividadeDao.insert(atividadeModel)
    }

    override suspend fun deleteAllAtividade() {
        atividadeDao.deleteAll()
    }
}