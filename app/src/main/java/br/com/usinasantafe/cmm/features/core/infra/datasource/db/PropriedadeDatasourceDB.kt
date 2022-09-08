package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.PropriedadeModel

interface PropriedadeDatasourceDB {

    suspend fun addPropriedade(propriedadeModel: PropriedadeModel): Long

    suspend fun deleteAllPropriedade()

}