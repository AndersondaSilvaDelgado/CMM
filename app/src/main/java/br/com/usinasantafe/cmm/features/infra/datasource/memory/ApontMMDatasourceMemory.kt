package br.com.usinasantafe.cmm.features.infra.datasource.memory

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM

interface ApontMMDatasourceMemory : ApontMMFertDatasourceMemory {

    suspend fun getApontMM(): ApontMM

}