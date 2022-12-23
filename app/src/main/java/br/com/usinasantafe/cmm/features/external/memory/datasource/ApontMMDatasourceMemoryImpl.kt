package br.com.usinasantafe.cmm.features.external.memory.datasource

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import br.com.usinasantafe.cmm.features.external.memory.AppDatabaseMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontMMDatasourceMemory
import javax.inject.Inject

class ApontMMDatasourceMemoryImpl @Inject constructor (
): ApontMMDatasourceMemory {

    override suspend fun getApontMM(): ApontMM {
        return AppDatabaseMemory.apontMM!!
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        if(checkApont()){
            return false
        }
        AppDatabaseMemory.apontMM!!.idAtivApont = idAtiv
        return true
    }

    override suspend fun setIdParada(idParada: Long): Boolean {
        if(checkApont()){
            return false
        }
        AppDatabaseMemory.apontMM!!.idParadaApont = idParada
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        if(checkApont()){
            return false
        }
        AppDatabaseMemory.apontMM!!.nroOSApont = nroOS
        return true
    }

    override suspend fun startApont(typeNote: TypeNote, idBoletim: Long): Boolean {
        AppDatabaseMemory.apontMM = null
        AppDatabaseMemory.apontMM = ApontMM(
            idBolApont = idBoletim,
            tipoApont = typeNote
        )
        return true
    }

    private fun checkApont(): Boolean{
        return AppDatabaseMemory.apontMM == null
    }

}