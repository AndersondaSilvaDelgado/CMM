package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.EquipModel
import kotlinx.coroutines.flow.Flow

interface EquipDatasourceWebService {

    suspend fun getEquip(nroEquip: String): Flow<Result<List<EquipModel>>>

}