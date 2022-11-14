package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel

interface ROSAtivDatasourceRoom {

    suspend fun addROSAtiv(rOSAtivModel: ROSAtivModel): Long

    suspend fun deleteAllROSAtiv()

}