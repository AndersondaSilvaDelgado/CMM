package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.stable.FrenteModel
import kotlinx.coroutines.flow.Flow

interface FrenteDatasourceWebService {

    suspend fun getAllFrente(): Flow<Result<List<FrenteModel>>>

}