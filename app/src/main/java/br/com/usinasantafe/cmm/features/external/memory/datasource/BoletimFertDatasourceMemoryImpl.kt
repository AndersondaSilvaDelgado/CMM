package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimFertDatasourceMemory
import javax.inject.Inject

class BoletimFertDatasourceMemoryImpl @Inject constructor (
): BoletimFertDatasourceMemory {

    override suspend fun clearBoletim() {
        AppDatabaseMemory.boletimFert = null
    }

    override suspend fun getBoletimFert(): BoletimFert {
        return AppDatabaseMemory.boletimFert!!
    }

    override suspend fun setHorimetroInicial(horimetroInicial: Double): Boolean {
        if(checkBoletim()){
            return false
        }
        AppDatabaseMemory.boletimFert!!.hodometroInicialBol = horimetroInicial
        return true
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        AppDatabaseMemory.boletimFert!!.idAtivBol = idAtiv
        return true
    }

    override suspend fun setIdTurno(idTurno: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        AppDatabaseMemory.boletimFert!!.idTurnoBol = idTurno
        return true
    }

    override suspend fun setMatricOperador(nroMatric: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        AppDatabaseMemory.boletimFert!!.matricFuncBol = nroMatric
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        AppDatabaseMemory.boletimFert!!.nroOSBol = nroOS
        return true
    }

    override suspend fun startBoletim(idEquip: Long): Boolean {
        AppDatabaseMemory.boletimFert = BoletimFert(
            statusBol = StatusData.INICIADO,
            idEquipBol = idEquip
        )
        return true
    }

    private fun checkBoletim(): Boolean{
        return AppDatabaseMemory.boletimFert == null
    }

}