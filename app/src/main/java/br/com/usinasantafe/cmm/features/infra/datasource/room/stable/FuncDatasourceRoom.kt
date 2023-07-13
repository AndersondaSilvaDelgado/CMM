package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.FuncRoomModel

interface FuncDatasourceRoom {

    suspend fun addAllFunc(vararg funcRoomModels: FuncRoomModel)

    suspend fun deleteAllFunc()

    suspend fun checkFuncNro(nroFunc: Long): Boolean

}