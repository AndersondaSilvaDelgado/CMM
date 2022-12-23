package br.com.usinasantafe.cmm.features.infra.datasource.memory

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert

interface ApontFertDatasourceMemory : ApontMMFertDatasourceMemory {

    suspend fun getApontFert(): ApontFert

}