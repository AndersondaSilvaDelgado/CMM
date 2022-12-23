package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.PropriedadeModel

interface PropriedadeDatasourceRoom {

    suspend fun addAllPropriedade(vararg propriedadeModels: PropriedadeModel)

    suspend fun deleteAllPropriedade()

}