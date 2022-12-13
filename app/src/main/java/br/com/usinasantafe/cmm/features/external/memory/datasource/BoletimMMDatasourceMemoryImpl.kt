package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMDatasourceMemory
import javax.inject.Inject

class BoletimMMDatasourceMemoryImpl @Inject constructor (
): BoletimMMDatasourceMemory{

    override suspend fun clearBoletim() {
        AppDatabaseMemory.boletimMM = null
    }

    override suspend fun getBoletimMM(): BoletimMM {
        return AppDatabaseMemory.boletimMM!!
    }

    override suspend fun setHorimetroInicial(horimetroInicial: Double): Boolean {
        AppDatabaseMemory.boletimMM?.hodometroInicialBol = horimetroInicial
        return true
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        AppDatabaseMemory.boletimMM?.ativPrincBol = idAtiv
        return true
    }

    override suspend fun setIdTurno(idTurno: Long): Boolean {
        AppDatabaseMemory.boletimMM?.idTurnoBol = idTurno
        return true
    }

    override suspend fun setMatricOperador(nroMatric: Long): Boolean {
        AppDatabaseMemory.boletimMM?.matricFuncBol = nroMatric
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        AppDatabaseMemory.boletimMM?.osBol = nroOS
        return true
    }

    override suspend fun startBoletim(idEquip: Long): Boolean {
        AppDatabaseMemory.boletimMM = BoletimMM(
            statusBol = StatusData.INICIADO,
            idEquipBol = idEquip
        )
        return true
    }

}