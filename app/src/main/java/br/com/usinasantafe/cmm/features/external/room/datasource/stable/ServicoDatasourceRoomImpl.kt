package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ServicoModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ServicoDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ServicoDatasourceRoom
import javax.inject.Inject

class ServicoDatasourceRoomImpl @Inject constructor(
    private val servicoDao: ServicoDao
): ServicoDatasourceRoom {

    override suspend fun addAllServico(vararg servicoModels: ServicoModel) {
        servicoDao.insertAll(*servicoModels)
    }

    override suspend fun deleteAllServico() {
        servicoDao.deleteAll()
    }

}