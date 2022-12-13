package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimFertModel

interface BoletimFertDatasourceRoom {

    suspend fun getBoletimAbertoFert(): BoletimFertModel

    suspend fun insertBoletimFert(boletimFertModel: BoletimFertModel): Boolean

}