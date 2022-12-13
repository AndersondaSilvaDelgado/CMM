package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.stable.MotoMecModel
import kotlinx.coroutines.flow.Flow

interface MotoMecDatasourceWebService {

    suspend fun getAllMotoMec(): Flow<Result<List<MotoMecModel>>>

}