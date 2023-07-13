package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.PressaoBocalRoomModel
import kotlinx.coroutines.flow.Flow

interface PressaoBocalDatasourceWebService {

    suspend fun getAllPressaoBocal(): Flow<Result<List<PressaoBocalRoomModel>>>

}