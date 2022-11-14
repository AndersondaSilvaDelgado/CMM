package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.EquipModel
import kotlinx.coroutines.flow.Flow

interface EquipDatasourceWebService {

    suspend fun getEquip(nroEquip: String): Flow<Result<List<EquipModel>>>

}