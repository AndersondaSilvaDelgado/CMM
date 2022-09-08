package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.REquipAtivModel

interface REquipAtivDatasourceDB {

    suspend fun addREquipAtiv(rEquipAtivModel: REquipAtivModel): Long

    suspend fun deleteAllREquipAtiv()

}