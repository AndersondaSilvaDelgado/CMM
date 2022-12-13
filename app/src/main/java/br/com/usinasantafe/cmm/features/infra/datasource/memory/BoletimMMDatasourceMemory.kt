package br.com.usinasantafe.cmm.features.infra.datasource.memory

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM

interface BoletimMMDatasourceMemory: BoletimMMFertDatasourceMemory {

    suspend fun getBoletimMM(): BoletimMM

}