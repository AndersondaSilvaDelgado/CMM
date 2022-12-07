package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.BoletimMMFert
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMFertDatasourceMemory
import javax.inject.Inject

class BoletimMMFertRepositoryImpl @Inject constructor(
    private val boletimMMFertDatasourceMemory: BoletimMMFertDatasourceMemory
): BoletimMMFertRepository {

    override suspend fun getBoletimMMFert(): BoletimMMFert {
        return boletimMMFertDatasourceMemory.getBoletimMMFert()
    }

    override suspend fun setIdAtivBoletimMMFert(idAtiv: Long): Boolean {
        return boletimMMFertDatasourceMemory.setIdAtiv(idAtiv)
    }

    override suspend fun startBoletimMMFert(): Boolean {
        return boletimMMFertDatasourceMemory.startBoletimMMFert()
    }

    override suspend fun setMatricFuncBoletimMMFert(matricOperador: String): Boolean {
        return boletimMMFertDatasourceMemory.setMatricOperador(matricOperador.toLong())
    }

    override suspend fun setIdEquipBoletimMMFert(idEquip: Long): Boolean {
        return boletimMMFertDatasourceMemory.setIdEquip(idEquip)
    }

    override suspend fun setIdTurnoBoletimMMFert(idTurno: Long): Boolean {
        return boletimMMFertDatasourceMemory.setIdTurno(idTurno)
    }

    override suspend fun setNroOSBoletimMMFert(nroOS: String): Boolean {
        return boletimMMFertDatasourceMemory.setNroOS(nroOS.toLong())
    }

}