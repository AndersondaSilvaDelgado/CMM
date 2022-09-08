package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ParadaModel

interface ParadaDatasourceDB {

    suspend fun addParada(paradaModel: ParadaModel): Long

    suspend fun deleteAllParada()

}