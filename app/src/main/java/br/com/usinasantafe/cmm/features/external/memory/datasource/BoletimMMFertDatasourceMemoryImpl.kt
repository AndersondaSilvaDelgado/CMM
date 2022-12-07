package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.BoletimMMFert
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMFertDatasourceMemory
import javax.inject.Inject

class BoletimMMFertDatasourceMemoryImpl @Inject constructor (
): BoletimMMFertDatasourceMemory{

    override suspend fun getBoletimMMFert(): BoletimMMFert {
        return AppDatabaseMemory.boletimMMFert!!
    }

    override suspend fun startBoletimMMFert(): Boolean {
        AppDatabaseMemory.boletimMMFert = BoletimMMFert(
            statusBolMMFert = StatusData.INICIADO,
            idBolMMFert = null,
            tipoBolMMFert = null,
            matricFuncBolMMFert = null,
            idEquipBolMMFert = null,
            idEquipBombaBolMMFert = null,
            idTurnoBolMMFert = null,
            hodometroInicialBolMMFert = null,
            hodometroFinalBolMMFert = null,
            osBolMMFert = null,
            ativPrincBolMMFert = null,
            dthrInicialBolMMFert = null,
            dthrFinalBolMMFert = null,
            dthrFinalLongBolMMFert = null,
            statusConBolMMFert = null,
            longitudeBolMMFert = null,
            latitudeBolMMFert = null,
        )
        return true
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        AppDatabaseMemory.boletimMMFert?.ativPrincBolMMFert = idAtiv
        return true
    }

    override suspend fun setMatricOperador(nroMatric: Long): Boolean {
        AppDatabaseMemory.boletimMMFert?.matricFuncBolMMFert = nroMatric
        return true
    }

    override suspend fun setIdEquip(idEquip: Long): Boolean {
        AppDatabaseMemory.boletimMMFert?.idEquipBolMMFert = idEquip
        return true
    }

    override suspend fun setIdTurno(idTurno: Long): Boolean {
        AppDatabaseMemory.boletimMMFert?.idTurnoBolMMFert = idTurno
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        AppDatabaseMemory.boletimMMFert?.osBolMMFert = nroOS
        return true
    }

}