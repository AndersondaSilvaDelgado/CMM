package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ComponenteRoomModel
import kotlinx.coroutines.flow.Flow

interface ComponenteDatasourceWebService {

    suspend fun getAllComponente(): Flow<Result<List<ComponenteRoomModel>>>

}