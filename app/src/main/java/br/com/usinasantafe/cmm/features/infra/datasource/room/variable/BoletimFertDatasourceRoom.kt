package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimFertRoomModel

interface BoletimFertDatasourceRoom {

    suspend fun getBoletimAbertoFert(): BoletimFertRoomModel

    suspend fun insertBoletimFert(boletimFertRoomModel: BoletimFertRoomModel): Boolean

}