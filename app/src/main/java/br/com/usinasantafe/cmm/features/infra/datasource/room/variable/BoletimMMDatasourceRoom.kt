package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.room.variable.BoletimMMRoomModel

interface BoletimMMDatasourceRoom {

    suspend fun checkBoletimAbertoMM(): Boolean

    suspend fun checkBoletimMMSend(): Boolean

    suspend fun deleteBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean

    suspend fun finishBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean

    suspend fun getBoletimAbertoMM(): BoletimMMRoomModel

    suspend fun getBoletimIdBol(idBol: Long): BoletimMMRoomModel

    suspend fun insertBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean

    suspend fun listBoletimMMSend(): List<BoletimMMRoomModel>

    suspend fun listBoletimMMFechadoSent(): List<BoletimMMRoomModel>

    suspend fun setHorimetroFinal(horimetroFinal: Double): Boolean

    suspend fun setStatusSent(idBol: Long): Boolean

    suspend fun setStatusSend(idBol: Long): Boolean

}