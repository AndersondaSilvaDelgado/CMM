package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.PressaoBocalModel
import kotlinx.coroutines.flow.Flow

interface PressaoBocalDatasourceWebService {

    suspend fun getAllPressaoBocal(): Flow<Result<List<PressaoBocalModel>>>

}