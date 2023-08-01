package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.external.room.dao.variable.BoletimMMDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.BoletimMMRoomModel
import java.util.*
import javax.inject.Inject

class BoletimMMDatasourceRoomImpl @Inject constructor (
    private val boletimMMDao: BoletimMMDao
): BoletimMMDatasourceRoom {

    override suspend fun checkBoletimAbertoMM(): Boolean {
        return boletimMMDao.listBoletimStatus(StatusData.OPEN).isNotEmpty()
    }

    override suspend fun checkBoletimMMSend(): Boolean {
        return boletimMMDao.listBoletimStatusEnvio(StatusSend.SEND).isNotEmpty()
    }

    override suspend fun deleteBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        return boletimMMDao.delete(boletimMMRoomModel) > 0
    }

    override suspend fun finishBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        boletimMMRoomModel.dthrFinalBolMM = Date().time
        boletimMMRoomModel.statusBolMM = StatusData.CLOSE
        boletimMMRoomModel.statusEnvioBolMM = StatusSend.SEND
        return boletimMMDao.update(boletimMMRoomModel) > 0
    }

    override suspend fun getBoletimAbertoMM(): BoletimMMRoomModel {
        return boletimMMDao.listBoletimStatus(StatusData.OPEN).single()
    }

    override suspend fun getBoletimIdBol(idBol: Long): BoletimMMRoomModel {
        return boletimMMDao.listBoletimIdBol(idBol).single()
    }

    override suspend fun insertBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        return boletimMMDao.insert(boletimMMRoomModel) > 0
    }

    override suspend fun listBoletimMMSend(): List<BoletimMMRoomModel> {
        return boletimMMDao.listBoletimStatusEnvio(StatusSend.SEND)
    }

    override suspend fun listBoletimMMFechadoSent(): List<BoletimMMRoomModel> {
        return boletimMMDao.listBoletimFluxoStatusEnvio(StatusData.CLOSE.ordinal.toLong(), StatusSend.SENT)
    }

    override suspend fun setHorimetroFinal(horimetroFinal: Double): Boolean {
        var boletim = getBoletimAbertoMM()
        boletim.hodometroFinalBolMM = horimetroFinal
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun setStatusSent(idBol: Long): Boolean {
        var boletim = getBoletimIdBol(idBol)
        boletim.statusEnvioBolMM = StatusSend.SENT
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun setStatusSend(idBol: Long): Boolean {
        var boletim = getBoletimIdBol(idBol)
        boletim.statusEnvioBolMM = StatusSend.SEND
        return boletimMMDao.update(boletim) > 0
    }

}