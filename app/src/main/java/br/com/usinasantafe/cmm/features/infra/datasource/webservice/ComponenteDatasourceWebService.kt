package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.ComponenteModel
import kotlinx.coroutines.flow.Flow

interface ComponenteDatasourceWebService {

    suspend fun getAllComponente(): Flow<Result<List<ComponenteModel>>>

}