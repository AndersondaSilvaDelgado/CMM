package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.FuncModel

interface FuncDatasourceRoom {

    suspend fun addFunc(funcModel: FuncModel): Long

    suspend fun deleteAllFunc()

    suspend fun checkFuncNro(nroFunc: Long): Boolean

}