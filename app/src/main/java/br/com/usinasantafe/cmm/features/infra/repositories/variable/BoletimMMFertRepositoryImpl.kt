package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMFertDatasourceMemory
import javax.inject.Inject

class BoletimMMFertRepositoryImpl @Inject constructor(
    private val boletimMMFertDatasourceMemory: BoletimMMFertDatasourceMemory
): BoletimMMFertRepository {

    override suspend fun startBoletimMMFert(): Boolean {
        boletimMMFertDatasourceMemory.startBoletimMMFert()
        return true
    }

}