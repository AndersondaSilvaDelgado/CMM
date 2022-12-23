package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ParadaModel
import kotlinx.coroutines.flow.Flow

interface ParadaDatasourceWebService {

    suspend fun getAllParada(): Flow<Result<List<ParadaModel>>>

}