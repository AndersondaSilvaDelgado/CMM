package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.PropriedadeModel
import kotlinx.coroutines.flow.Flow

interface PropriedadeDatasourceWebService {

    suspend fun getAllPropriedade(): Flow<Result<List<PropriedadeModel>>>

}