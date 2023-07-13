package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ROSAtivRoomModel
import kotlinx.coroutines.flow.Flow

interface ROSAtivDatasourceWebService {

    suspend fun getAllROSAtiv(): Flow<Result<List<ROSAtivRoomModel>>>

    suspend fun recoverROSAtiv(nroOS: String): Flow<Result<List<ROSAtivRoomModel>>>

}