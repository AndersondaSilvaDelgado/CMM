package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontFertDatasourceMemory
import javax.inject.Inject

class ApontFertDatasourceMemoryImpl @Inject constructor (
): ApontFertDatasourceMemory {

    override suspend fun startApont(tipo: Long, idBoletim: Long): Boolean {
        AppDatabaseMemory.apontFert = ApontFert(
            idBolApont = idBoletim,
            tipoApont = tipo
        )
        return true
    }

}