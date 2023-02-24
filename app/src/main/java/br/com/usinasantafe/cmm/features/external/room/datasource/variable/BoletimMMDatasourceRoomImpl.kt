package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.external.room.dao.variable.BoletimMMDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMRoomModel
import java.util.*
import javax.inject.Inject

class BoletimMMDatasourceRoomImpl @Inject constructor (
    private val boletimMMDao: BoletimMMDao
): BoletimMMDatasourceRoom {

    override suspend fun checkBoletimAbertoMM(): Boolean {
        return boletimMMDao.listBoletimStatus(StatusData.ABERTO.ordinal.toLong()).isNotEmpty()
    }

    override suspend fun checkBoletimMMSend(): Boolean {
        return boletimMMDao.listBoletimStatusEnvio(StatusSend.ENVIAR.ordinal.toLong()).isNotEmpty()
    }

    override suspend fun finishBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        var boletim = getBoletimAbertoMM()
        boletim.dthrFinalBolMM = Date().time
        boletim.statusBolMM = StatusData.FECHADO.ordinal.toLong()
        boletim.statusEnvioBolMM = StatusSend.ENVIAR.ordinal.toLong()
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun getBoletimAbertoMM(): BoletimMMRoomModel {
        return boletimMMDao.listBoletimStatus(StatusData.ABERTO.ordinal.toLong()).single()
    }

    override suspend fun getBoletimIdBol(idBol: Long): BoletimMMRoomModel {
        return boletimMMDao.listBoletimIdBol(idBol).single()
    }

    override suspend fun insertBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        return boletimMMDao.insert(boletimMMRoomModel) > 0
    }

    override suspend fun listBoletimMMEnviar(): List<BoletimMMRoomModel> {
        return boletimMMDao.listBoletimStatusEnvio(StatusSend.ENVIAR.ordinal.toLong())
    }

    override suspend fun setHorimetroFinal(horimetroFinal: Double): Boolean {
        var boletim = getBoletimAbertoMM()
        boletim.hodometroFinalBolMM = horimetroFinal
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun setStatusEnviado(idBol: Long): Boolean {
        var boletim = getBoletimIdBol(idBol)
        boletim.statusEnvioBolMM = StatusSend.ENVIADO.ordinal.toLong()
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun setStatusEnviar(idBol: Long): Boolean {
        var boletim = getBoletimIdBol(idBol)
        boletim.statusEnvioBolMM = StatusSend.ENVIAR.ordinal.toLong()
        return boletimMMDao.update(boletim) > 0
    }

}