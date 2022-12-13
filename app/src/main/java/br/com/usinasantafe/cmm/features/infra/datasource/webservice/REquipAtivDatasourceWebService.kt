package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.stable.REquipAtivModel
import kotlinx.coroutines.flow.Flow

interface REquipAtivDatasourceWebService {

    suspend fun getREquipAtiv(nroEquip: String): Flow<Result<List<REquipAtivModel>>>

}