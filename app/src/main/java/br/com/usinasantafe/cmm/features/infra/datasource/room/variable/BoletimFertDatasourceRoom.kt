package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.room.variable.BoletimFertRoomModel

interface BoletimFertDatasourceRoom {

    suspend fun checkBoletimAbertoFert(): Boolean

    suspend fun getBoletimAbertoFert(): BoletimFertRoomModel

    suspend fun insertBoletimFert(boletimFertRoomModel: BoletimFertRoomModel): Boolean

}