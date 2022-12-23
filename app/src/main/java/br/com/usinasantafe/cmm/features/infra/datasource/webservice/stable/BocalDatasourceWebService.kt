package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.BocalModel
import kotlinx.coroutines.flow.Flow

interface BocalDatasourceWebService {

    suspend fun getAllBocal(): Flow<Result<List<BocalModel>>>

}