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
        return boletimMMDao.listBoletimFluxo(StatusData.ABERTO).isNotEmpty()
    }

    override suspend fun checkBoletimMMSend(): Boolean {
        return boletimMMDao.listBoletimStatusEnvio(StatusSend.ENVIAR).isNotEmpty()
    }

    override suspend fun deleteBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        return boletimMMDao.delete(boletimMMRoomModel) > 0
    }

    override suspend fun finishBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        var boletim = getBoletimAbertoMM()
        boletim.dthrFinalBolMM = Date().time
        boletim.statusBolMM = StatusData.FECHADO
        boletim.statusEnvioBolMM = StatusSend.ENVIAR
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun getBoletimAbertoMM(): BoletimMMRoomModel {
        return boletimMMDao.listBoletimFluxo(StatusData.ABERTO).single()
    }

    override suspend fun getBoletimIdBol(idBol: Long): BoletimMMRoomModel {
        return boletimMMDao.listBoletimIdBol(idBol).single()
    }

    override suspend fun insertBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        return boletimMMDao.insert(boletimMMRoomModel) > 0
    }

    override suspend fun listBoletimMMEnviar(): List<BoletimMMRoomModel> {
        return boletimMMDao.listBoletimStatusEnvio(StatusSend.ENVIAR)
    }

    override suspend fun listBoletimMMFechadoEnviado(): List<BoletimMMRoomModel> {
        return boletimMMDao.listBoletimFluxoStatusEnvio(StatusData.FECHADO.ordinal.toLong(), StatusSend.ENVIADO)
    }

    override suspend fun setHorimetroFinal(horimetroFinal: Double): Boolean {
        var boletim = getBoletimAbertoMM()
        boletim.hodometroFinalBolMM = horimetroFinal
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun setStatusEnviado(idBol: Long): Boolean {
        var boletim = getBoletimIdBol(idBol)
        boletim.statusEnvioBolMM = StatusSend.ENVIADO
        return boletimMMDao.update(boletim) > 0
    }

    override suspend fun setStatusEnviar(idBol: Long): Boolean {
        var boletim = getBoletimIdBol(idBol)
        boletim.statusEnvioBolMM = StatusSend.ENVIAR
        return boletimMMDao.update(boletim) > 0
    }

}