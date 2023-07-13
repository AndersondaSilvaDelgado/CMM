package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ServicoRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ServicoDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ServicoDatasourceRoom
import javax.inject.Inject

class ServicoDatasourceRoomImpl @Inject constructor(
    private val servicoDao: ServicoDao
): ServicoDatasourceRoom {

    override suspend fun addAllServico(vararg servicoRoomModels: ServicoRoomModel) {
        servicoDao.insertAll(*servicoRoomModels)
    }

    override suspend fun deleteAllServico() {
        servicoDao.deleteAll()
    }

}