package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.RAtivParadaModel

interface RAtivParadaDatasourceDB {

    suspend fun addRAtivParada(rAtivParadaModel: RAtivParadaModel): Long

    suspend fun deleteAllRAtivParada()

}