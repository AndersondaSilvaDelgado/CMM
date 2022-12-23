package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.OperMotoMecModel
import kotlinx.coroutines.flow.Flow

interface OperMotoMecDatasourceWebService {

    suspend fun getAllOperMotoMec(): Flow<Result<List<OperMotoMecModel>>>

}