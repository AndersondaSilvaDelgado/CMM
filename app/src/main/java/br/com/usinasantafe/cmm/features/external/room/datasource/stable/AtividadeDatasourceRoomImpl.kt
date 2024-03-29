package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.external.room.dao.stable.AtividadeDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.AtividadeDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.stable.AtividadeRoomModel
import javax.inject.Inject

class AtividadeDatasourceRoomImpl @Inject constructor (
    private val atividadeDao: AtividadeDao
): AtividadeDatasourceRoom {

    override suspend fun addAllAtividade(vararg atividadeRoomModels: AtividadeRoomModel) {
        atividadeDao.insertAll(*atividadeRoomModels)
    }

    override suspend fun deleteAllAtividade() {
        atividadeDao.deleteAll()
    }

    override suspend fun listInIdAtiv(vararg idAtivs: Long): List<AtividadeRoomModel> {
        return atividadeDao.listInIdAtiv(*idAtivs)
    }

}