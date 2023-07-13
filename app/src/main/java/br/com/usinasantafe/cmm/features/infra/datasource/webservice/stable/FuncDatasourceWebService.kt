package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.FuncRoomModel
import kotlinx.coroutines.flow.Flow

interface FuncDatasourceWebService {

    suspend fun getAllFunc(): Flow<Result<List<FuncRoomModel>>>

}