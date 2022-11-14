package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.features.domain.entities.BoletimMMFert
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMFertDatasourceMemory
import javax.inject.Inject

class BoletimMMFertDatasourceMemoryImpl @Inject constructor (
        ): BoletimMMFertDatasourceMemory{

    override suspend fun startBoletimMMFert() {
        AppDatabaseMemory.boletimMMFert = BoletimMMFert(
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
            statusBolMMFert = null,
            statusConBolMMFert = null,
            longitudeBolMMFert = null,
            latitudeBolMMFert = null,
        )
    }

    override suspend fun setOperador(nroMatric: Long) {
        AppDatabaseMemory.boletimMMFert?.matricFuncBolMMFert = nroMatric
    }

}