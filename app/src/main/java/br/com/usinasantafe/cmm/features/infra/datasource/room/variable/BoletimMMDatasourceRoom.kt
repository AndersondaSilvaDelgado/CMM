package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMRoomModel

interface BoletimMMDatasourceRoom {

    suspend fun checkBoletimAbertoMM(): Boolean

    suspend fun checkBoletimFechadoMM(): Boolean

    suspend fun finishBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean

    suspend fun getBoletimAbertoMM(): BoletimMMRoomModel

    suspend fun insertBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean

    suspend fun listBoletimAbertoMM(): List<BoletimMMRoomModel>

    suspend fun setHorimetroFinal(horimetroFinal: Double): Boolean

}