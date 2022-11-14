package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.REquipAtivModel

interface REquipAtivDatasourceRoom {

    suspend fun addREquipAtiv(rEquipAtivModel: REquipAtivModel): Long

    suspend fun deleteAllREquipAtiv()

}