package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.EquipSegModel
import kotlinx.coroutines.flow.Flow

interface EquipSegDatasourceWebService {

    suspend fun getAllEquipSeg(): Flow<Result<List<EquipSegModel>>>

}