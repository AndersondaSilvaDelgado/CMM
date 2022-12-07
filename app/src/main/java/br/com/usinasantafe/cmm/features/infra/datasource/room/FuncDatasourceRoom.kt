package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.FuncModel

interface FuncDatasourceRoom {

    suspend fun addAllFunc(vararg funcModels: FuncModel)

    suspend fun deleteAllFunc()

    suspend fun checkFuncNro(nroFunc: Long): Boolean

}