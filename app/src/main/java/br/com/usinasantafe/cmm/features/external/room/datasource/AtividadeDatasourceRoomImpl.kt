package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.external.room.dao.AtividadeDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.AtividadeDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.stable.AtividadeModel
import javax.inject.Inject

class AtividadeDatasourceRoomImpl @Inject constructor (
    private val atividadeDao: AtividadeDao
): AtividadeDatasourceRoom {

    override suspend fun addAllAtividade(vararg atividadeModels: AtividadeModel) {
        atividadeDao.insertAll(*atividadeModels)
    }

    override suspend fun deleteAllAtividade() {
        atividadeDao.deleteAll()
    }

    override suspend fun listInIdAtiv(vararg idAtivs: Long): List<AtividadeModel> {
        return atividadeDao.listInIdAtiv(*idAtivs)
    }

}