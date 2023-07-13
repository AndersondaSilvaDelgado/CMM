package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.PropriedadeRoomModel
import kotlinx.coroutines.flow.Flow

interface PropriedadeDatasourceWebService {

    suspend fun getAllPropriedade(): Flow<Result<List<PropriedadeRoomModel>>>

}