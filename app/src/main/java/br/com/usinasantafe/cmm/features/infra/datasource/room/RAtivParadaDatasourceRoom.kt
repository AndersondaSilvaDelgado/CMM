package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.RAtivParadaModel

interface RAtivParadaDatasourceRoom {

    suspend fun addRAtivParada(rAtivParadaModel: RAtivParadaModel): Long

    suspend fun deleteAllRAtivParada()

}