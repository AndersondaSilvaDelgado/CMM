package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.stable.PneuModel
import kotlinx.coroutines.flow.Flow

interface PneuDatasourceWebService {

    suspend fun getAllPneu(): Flow<Result<List<PneuModel>>>

}