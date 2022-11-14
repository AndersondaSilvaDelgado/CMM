package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.ItemOSMecanModel
import kotlinx.coroutines.flow.Flow

interface ItemOSMecanDatasourceWebService {

    suspend fun getAllItemOSMecan(): Flow<Result<List<ItemOSMecanModel>>>

}