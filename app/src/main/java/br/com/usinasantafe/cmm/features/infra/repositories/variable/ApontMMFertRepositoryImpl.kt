package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontFertDatasourceMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontMMDatasourceMemory
import javax.inject.Inject

class ApontMMFertRepositoryImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val apontFertDatasourceMemory: ApontFertDatasourceMemory,
    private val apontMMDatasourceMemory: ApontMMDatasourceMemory,
    private val boletimMMFertRepository: BoletimMMFertRepository
) : ApontMMFertRepository {

    override suspend fun startApontMMFert(tipo: Long): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceMemory.startApont(tipo, boletimMMFertRepository.getIdBoletim())
        } else {
            apontFertDatasourceMemory.startApont(tipo, boletimMMFertRepository.getIdBoletim())
        }
    }

}