package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.ParadaModel
import kotlinx.coroutines.flow.Flow

interface ParadaDatasourceWebService {

    suspend fun getAllParada(): Flow<Result<List<ParadaModel>>>

}