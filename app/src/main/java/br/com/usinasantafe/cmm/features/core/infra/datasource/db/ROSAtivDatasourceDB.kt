package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ROSAtivModel

interface ROSAtivDatasourceDB {

    suspend fun addROSAtiv(rOSAtivModel: ROSAtivModel): Long

    suspend fun deleteAllROSAtiv()

}