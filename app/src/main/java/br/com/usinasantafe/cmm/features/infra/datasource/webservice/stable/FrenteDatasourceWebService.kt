package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.FrenteRoomModel
import kotlinx.coroutines.flow.Flow

interface FrenteDatasourceWebService {

    suspend fun getAllFrente(): Flow<Result<List<FrenteRoomModel>>>

}