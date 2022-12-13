package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.stable.ROSAtivModel

interface ROSAtivDatasourceRoom {

    suspend fun addAllROSAtiv(vararg rOSAtivModels: ROSAtivModel)

    suspend fun deleteAllROSAtiv()

    suspend fun listROSAtiv(idOS: Long): List<ROSAtivModel>

}