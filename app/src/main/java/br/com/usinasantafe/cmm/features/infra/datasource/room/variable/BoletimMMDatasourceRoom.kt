package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMRoomModel

interface BoletimMMDatasourceRoom {

    suspend fun getBoletimAbertoMM(): BoletimMMRoomModel

    suspend fun insertBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean

    suspend fun listBoletimAbertoMM(): List<BoletimMMRoomModel>

}