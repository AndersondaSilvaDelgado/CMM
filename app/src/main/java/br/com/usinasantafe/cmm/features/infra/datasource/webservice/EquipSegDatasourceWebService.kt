package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.EquipSegModel
import kotlinx.coroutines.flow.Flow

interface EquipSegDatasourceWebService {

    suspend fun getAllEquipSeg(): Flow<Result<List<EquipSegModel>>>

}