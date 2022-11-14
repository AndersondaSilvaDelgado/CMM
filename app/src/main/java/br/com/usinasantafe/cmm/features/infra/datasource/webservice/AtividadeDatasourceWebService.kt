package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.AtividadeModel
import kotlinx.coroutines.flow.Flow

interface AtividadeDatasourceWebService {

    suspend fun getAllAtividade(): Flow<Result<List<AtividadeModel>>>

}