package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.external.room.dao.variable.ApontMMDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.ApontMMRoomModel
import javax.inject.Inject

class ApontMMDatasourceRoomImpl @Inject constructor (
    private val apontMMDao: ApontMMDao
): ApontMMDatasourceRoom {

    override suspend fun checkApontMMSend(): Boolean {
        return apontMMDao.listApontStatusEnvio(statusEnvio = StatusSend.ENVIAR).isNotEmpty()
    }

    override suspend fun insertApontMM(apontMMRoomModel: ApontMMRoomModel): Boolean {
        return apontMMDao.insert(apontMMRoomModel) > 0
    }

    override suspend fun deleteApontMM(apontMMRoomModel: ApontMMRoomModel): Boolean {
        return apontMMDao.delete(apontMMRoomModel) > 0
    }

    override suspend fun listApontIdBolStatusEnviar(idBol: Long): List<ApontMMRoomModel> {
        return apontMMDao.listApontIdBolStatusEnviar(idBol = idBol, statusEnvio = StatusSend.ENVIAR)
    }

    override suspend fun listApontIdBolStatusEnviado(idBol: Long): List<ApontMMRoomModel> {
        return apontMMDao.listApontIdBolStatusEnviar(idBol = idBol, statusEnvio = StatusSend.ENVIADO)
    }

    override suspend fun updateApontEnviadoMM(apontMMRoomModel: ApontMMRoomModel): Boolean {
        var apont = apontMMDao.listApontIdApont(apontMMRoomModel.idApontMM!!).single()
        apont.statusEnvioApontMM = StatusSend.ENVIADO
        return apontMMDao.update(apont) > 0
    }

}