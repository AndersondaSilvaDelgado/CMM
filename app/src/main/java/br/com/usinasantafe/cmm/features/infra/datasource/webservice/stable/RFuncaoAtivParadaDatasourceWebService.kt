package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.RFuncaoAtivParadaRoomModel
import kotlinx.coroutines.flow.Flow

interface RFuncaoAtivParadaDatasourceWebService {

    suspend fun getAllRFuncaoAtivParada(): Flow<Result<List<RFuncaoAtivParadaRoomModel>>>

}