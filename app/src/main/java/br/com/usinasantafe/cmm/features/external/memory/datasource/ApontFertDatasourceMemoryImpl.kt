package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontFertDatasourceMemory
import javax.inject.Inject

class ApontFertDatasourceMemoryImpl @Inject constructor (
): ApontFertDatasourceMemory {

    override suspend fun getApontFert(): ApontFert {
        return AppDatabaseMemory.apontFert!!
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        if(checkApont()){
            return false
        }
        AppDatabaseMemory.apontFert!!.idAtivApont = idAtiv
        return true
    }

    override suspend fun setIdParada(idParada: Long): Boolean {
        if(checkApont()){
            return false
        }
        AppDatabaseMemory.apontFert!!.idParadaApont = idParada
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        if(checkApont()){
            return false
        }
        AppDatabaseMemory.apontFert!!.nroOSApont == nroOS
        return true
    }

    override suspend fun startApont(typeNote: TypeNote, idBoletim: Long): Boolean {
        AppDatabaseMemory.apontFert = null
        AppDatabaseMemory.apontFert = ApontFert(
            idBolApont = idBoletim,
            tipoApont = typeNote
        )
        return true
    }

    private fun checkApont(): Boolean{
        return AppDatabaseMemory.apontFert == null
    }

}