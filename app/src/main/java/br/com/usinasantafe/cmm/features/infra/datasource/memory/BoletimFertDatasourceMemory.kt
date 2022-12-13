package br.com.usinasantafe.cmm.features.infra.datasource.memory

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert

interface BoletimFertDatasourceMemory: BoletimMMFertDatasourceMemory {

    suspend fun getBoletimFert(): BoletimFert

}