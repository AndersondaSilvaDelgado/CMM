package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ServicoRoomModel
import kotlinx.coroutines.flow.Flow

interface ServicoDatasourceWebService {

    suspend fun getAllServico(): Flow<Result<List<ServicoRoomModel>>>

}