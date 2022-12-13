package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMModel

interface BoletimMMDatasourceRoom {

    suspend fun getBoletimAbertoMM(): BoletimMMModel

    suspend fun insertBoletimMM(boletimMMModel: BoletimMMModel): Boolean

}