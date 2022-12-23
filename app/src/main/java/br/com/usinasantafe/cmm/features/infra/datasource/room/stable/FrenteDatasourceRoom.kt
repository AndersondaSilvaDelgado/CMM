package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.FrenteModel

interface FrenteDatasourceRoom {

    suspend fun addAllFrente(vararg frenteModels: FrenteModel)

    suspend fun deleteAllFrente()

}