package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.FuncModel

interface FuncDatasourceDB {

    suspend fun addFunc(funcModel: FuncModel): Long

    suspend fun deleteAllFunc()

}