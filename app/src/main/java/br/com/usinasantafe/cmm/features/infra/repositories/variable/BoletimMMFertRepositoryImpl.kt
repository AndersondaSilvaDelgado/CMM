package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimFertDatasourceMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMDatasourceMemory
import br.com.usinasantafe.cmm.features.infra.datasource.room.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.toBoletimFertModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.toBoletimMMModel
import javax.inject.Inject

class BoletimMMFertRepositoryImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val boletimMMDatasourceMemory: BoletimMMDatasourceMemory,
    private val boletimFertDatasourceMemory: BoletimFertDatasourceMemory,
    private val boletimMMDatasourceRoom: BoletimMMDatasourceRoom,
    private val boletimFertDatasourceRoom: BoletimFertDatasourceRoom
) : BoletimMMFertRepository {

    override suspend fun clearBoletimMMFert() {
        boletimMMDatasourceMemory.clearBoletim()
        boletimFertDatasourceMemory.clearBoletim()
    }

    override suspend fun getAtiv(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().ativPrincBolMM!!
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().ativPrincBolFert!!
        }
    }

    override suspend fun getIdBoletim(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().idBolMM!!
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().idBolFert!!
        }
    }

    override suspend fun getIdEquip(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.getBoletimMM().idEquipBol!!
        } else {
            boletimFertDatasourceMemory.getBoletimFert().idEquipBol!!
        }
    }

    override suspend fun getOS(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.getBoletimMM().osBol!!
        } else {
            boletimFertDatasourceMemory.getBoletimFert().osBol!!
        }
    }

    override suspend fun insertBoletimMMFert(): Boolean {
        var ret = if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.insertBoletimMM(boletimMMDatasourceMemory.getBoletimMM().toBoletimMMModel())
        } else {
            boletimFertDatasourceRoom.insertBoletimFert(boletimFertDatasourceMemory.getBoletimFert().toBoletimFertModel())
        }
        if (ret) clearBoletimMMFert()
        return ret
    }

    override suspend fun setHorimetroInicialBoletimMMFert(horimetroInicial: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.setHorimetroInicial(
                horimetroInicial.replace(",", ".").toDouble()
            )
        } else {
            boletimFertDatasourceMemory.setHorimetroInicial(
                horimetroInicial.replace(",", ".").toDouble()
            )
        }
    }

    override suspend fun setIdAtivBoletimMMFert(idAtiv: Long): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.setIdAtiv(idAtiv)
        } else {
            boletimFertDatasourceMemory.setIdAtiv(idAtiv)
        }
    }

    override suspend fun startBoletimMMFert(): Boolean {
        clearBoletimMMFert()
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.startBoletim(equipRepository.getEquip().idEquip)
        } else {
            boletimFertDatasourceMemory.startBoletim(equipRepository.getEquip().idEquip)
        }
    }

    override suspend fun setMatricFuncBoletimMMFert(matricOperador: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.setMatricOperador(matricOperador.toLong())
        } else {
            boletimFertDatasourceMemory.setMatricOperador(matricOperador.toLong())
        }
    }

    override suspend fun setIdTurnoBoletimMMFert(idTurno: Long): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.setIdTurno(idTurno)
        } else {
            boletimFertDatasourceMemory.setIdTurno(idTurno)
        }
    }

    override suspend fun setNroOSBoletimMMFert(nroOS: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.setNroOS(nroOS.toLong())
        } else {
            boletimFertDatasourceMemory.setNroOS(nroOS.toLong())
        }
    }

}