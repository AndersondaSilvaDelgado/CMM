package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontMMDatasourceMemory
import javax.inject.Inject

class ApontMMDatasourceMemoryImpl @Inject constructor (
): ApontMMDatasourceMemory {

    override suspend fun startApont(tipo: Long, idBoletim: Long): Boolean {
        AppDatabaseMemory.apontMM = ApontMM(
            idBolApont = idBoletim,
            tipoApont = tipo
        )
        return true
    }

}