package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ParadaModel

interface ParadaDatasourceRoom {

    suspend fun addParada(paradaModel: ParadaModel): Long

    suspend fun deleteAllParada()

}