package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.AtividadeRoomModel
import kotlinx.coroutines.flow.Flow

interface AtividadeDatasourceWebService {

    suspend fun getAllAtividade(): Flow<Result<List<AtividadeRoomModel>>>

}