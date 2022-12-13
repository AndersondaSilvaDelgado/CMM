package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.stable.TurnoModel
import kotlinx.coroutines.flow.Flow

interface TurnoDatasourceWebService {

    suspend fun getAllTurno(): Flow<Result<List<TurnoModel>>>

}