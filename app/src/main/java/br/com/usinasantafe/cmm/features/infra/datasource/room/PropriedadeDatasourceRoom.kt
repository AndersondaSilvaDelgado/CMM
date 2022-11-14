package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.PropriedadeModel

interface PropriedadeDatasourceRoom {

    suspend fun addPropriedade(propriedadeModel: PropriedadeModel): Long

    suspend fun deleteAllPropriedade()

}