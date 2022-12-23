package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ComponenteModel
import kotlinx.coroutines.flow.Flow

interface ComponenteDatasourceWebService {

    suspend fun getAllComponente(): Flow<Result<List<ComponenteModel>>>

}