package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.REquipPneuModel
import kotlinx.coroutines.flow.Flow

interface REquipPneuDatasourceWebService {

    suspend fun getREquipPneu(nroEquip: String): Flow<Result<List<REquipPneuModel>>>

}