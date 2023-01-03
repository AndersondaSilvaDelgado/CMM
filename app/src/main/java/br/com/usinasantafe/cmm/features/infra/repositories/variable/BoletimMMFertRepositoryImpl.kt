package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimFertDatasourceMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMDatasourceMemory
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.MotoMecDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.variable.room.*
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.toBoletimMM
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.toBoletimMMWebServiceModel
import javax.inject.Inject

class BoletimMMFertRepositoryImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val boletimMMDatasourceMemory: BoletimMMDatasourceMemory,
    private val boletimFertDatasourceMemory: BoletimFertDatasourceMemory,
    private val boletimMMDatasourceRoom: BoletimMMDatasourceRoom,
    private val boletimFertDatasourceRoom: BoletimFertDatasourceRoom,
    private val apontMMDatasourceRoom: ApontMMDatasourceRoom,
    private val motoMecDatasourceWebService: MotoMecDatasourceWebService
) : BoletimMMFertRepository {

    override suspend fun checkAbertoBoletimMMFert(): Boolean {
        return boletimMMDatasourceRoom.checkBoletimAbertoMM() || boletimFertDatasourceRoom.checkBoletimAbertoFert()
    }

    override suspend fun clearBoletimMMFert() {
        boletimMMDatasourceMemory.clearBoletim()
        boletimFertDatasourceMemory.clearBoletim()
    }

    override suspend fun getAtiv(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().idAtivBolMM
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().idAtivBolFert
        }
    }

    override suspend fun getIdBoletim(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().idBolMM!!
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().idBolFert!!
        }
    }

    override suspend fun getOS(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.getBoletimMM().nroOSBol!!
        } else {
            boletimFertDatasourceMemory.getBoletimFert().nroOSBol!!
        }
    }

    override suspend fun insertBoletimMMFert(): Boolean {
        var ret = if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.insertBoletimMM(boletimMMDatasourceMemory.getBoletimMM().toBoletimMMRoomModel())
        } else {
            boletimFertDatasourceRoom.insertBoletimFert(boletimFertDatasourceMemory.getBoletimFert().toBoletimFertRoomModel())
        }
        if (ret) clearBoletimMMFert()
        return ret
    }

    override suspend fun sendBoletimMMAbertoFert(): Result<List<BoletimMM>> {
        var listBoletim: List<BoletimMM> = boletimMMDatasourceRoom.listBoletimAbertoMM().map { boletimMMRoomModel ->
            var boletimMM = boletimMMRoomModel.toBoletimMM()
            boletimMM.apontList = apontMMDatasourceRoom.listApontIdBol(boletimMM.idBol!!).map { it.toApontMM() }
            boletimMM
        }
        var result = motoMecDatasourceWebService.sendMotoMec(listBoletim.map { it.toBoletimMMWebServiceModel() })
        return result.map { boletimMMList -> boletimMMList.map { it.toBoletimMM() }}
    }

    override suspend fun sentBoletimMMAbertoFert(boletimMMList: List<BoletimMM>) {
        boletimMMList.forEach { boletimMM ->
            boletimMM.apontList!!.forEach {
                apontMMDatasourceRoom.updateApontEnviadoMM(it.toApontMMRoomModel())
            }
        }
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

    override suspend fun startBoletimMMFert(): Boolean {
        clearBoletimMMFert()
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceMemory.startBoletim(equipRepository.getEquip().idEquip)
        } else {
            boletimFertDatasourceMemory.startBoletim(equipRepository.getEquip().idEquip)
        }
    }

}