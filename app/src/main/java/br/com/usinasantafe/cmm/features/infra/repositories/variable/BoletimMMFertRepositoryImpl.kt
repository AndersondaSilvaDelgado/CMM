package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.BoletimFertDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.BoletimMMDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.MotoMecDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.room.variable.*
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.toBoletimMM
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.toBoletimMMWebServiceModel
import javax.inject.Inject

class BoletimMMFertRepositoryImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val boletimMMDatasourceSharedPreferences: BoletimMMDatasourceSharedPreferences,
    private val boletimFertDatasourceSharedPreferences: BoletimFertDatasourceSharedPreferences,
    private val boletimMMDatasourceRoom: BoletimMMDatasourceRoom,
    private val boletimFertDatasourceRoom: BoletimFertDatasourceRoom,
    private val apontMMDatasourceRoom: ApontMMDatasourceRoom,
    private val motoMecDatasourceWebService: MotoMecDatasourceWebService
) : BoletimMMFertRepository {

    override suspend fun checkAbertoBoletimMMFert(): Boolean {
        return boletimMMDatasourceRoom.checkBoletimAbertoMM()
    }

    override suspend fun checkBoletimSend(): Boolean {
        return boletimMMDatasourceRoom.checkBoletimMMSend()
    }

    override suspend fun deleteBoletimEnviado(): Boolean {
        var listBoletim = boletimMMDatasourceRoom.listBoletimMMFechadoEnviado()
        listBoletim.forEach { boletimMMRoomModel ->
            var listApont = apontMMDatasourceRoom.listApontIdBolStatusEnviar(boletimMMRoomModel.idBolMM!!)
            listApont.forEach { apontMMRoomModel ->
                if(!apontMMDatasourceRoom.deleteApontMM(apontMMRoomModel)){
                    return false
                }
            }
            if(!boletimMMDatasourceRoom.deleteBoletimMM(boletimMMRoomModel)){
                return false
            }
        }
        return true
    }

    override suspend fun finishBoletimMMFert(): Boolean {
        return boletimMMDatasourceRoom.finishBoletimMM(boletimMMDatasourceRoom.getBoletimAbertoMM())
    }

    override suspend fun getIdAtivBoletimAberto(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().idAtivBolMM
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().idAtivBolFert
        }
    }

    override suspend fun getIdBoletimAberto(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().idBolMM!!
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().idBolFert!!
        }
    }

    override suspend fun getNroMatricFuncBoletimAberto(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().matricFuncBolMM
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().matricFuncBolFert
        }
    }

    override suspend fun getNroOSBoletimAberto(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.getBoletimMM().nroOSBol!!
        } else {
            boletimFertDatasourceSharedPreferences.getBoletimFert().nroOSBol!!
        }
    }

    override suspend fun getIdTurnoBoletimAberto(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.getBoletimAbertoMM().idTurnoBolMM
        } else {
            boletimFertDatasourceRoom.getBoletimAbertoFert().idTurnoBolFert
        }
    }

    override suspend fun insertBoletimMMFert(): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.insertBoletimMM(boletimMMDatasourceSharedPreferences.getBoletimMM().toBoletimMMRoomModel())
        } else {
            boletimFertDatasourceRoom.insertBoletimFert(boletimFertDatasourceSharedPreferences.getBoletimFert().toBoletimFertRoomModel())
        }
    }

    override suspend fun sendBoletimMMFert(): Result<List<BoletimMM>> {
        var listBoletim: List<BoletimMM> = boletimMMDatasourceRoom.listBoletimMMEnviar().map { boletimMMRoomModel ->
            var boletimMM = boletimMMRoomModel.toBoletimMM()
            boletimMM.apontList = apontMMDatasourceRoom.listApontIdBolStatusEnviar(boletimMM.idBol!!).map { it.toApontMM() }
            boletimMM
        }
        var result = motoMecDatasourceWebService.sendMotoMec(listBoletim.map { it.toBoletimMMWebServiceModel() })
        return result.map { boletimMMList -> boletimMMList.map { it.toBoletimMM() }}
    }

    override suspend fun sentBoletimMMFert(boletimMMList: List<BoletimMM>) {
        boletimMMList.forEach { boletimMM ->
            boletimMM.apontList!!.forEach {
                apontMMDatasourceRoom.updateApontEnviadoMM(it.toApontMMRoomModel())
            }
            boletimMMDatasourceRoom.setStatusEnviado(boletimMM.idBol!!)
        }
    }

    override suspend fun setHorimetroFinalBoletimMMFert(horimetroFinal: String): Boolean {
        var horimetro = horimetroFinal.replace(",", ".").toDouble()
        var check = boletimMMDatasourceRoom.setHorimetroFinal(horimetro)
        if(!check) return check
        return equipRepository.updateHorimetroEquip(horimetro)
    }

    override suspend fun setHorimetroInicialBoletimMMFert(horimetroInicial: String): Boolean {
        var horimetro = horimetroInicial.replace(",", ".").toDouble()
        var check = if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.setHorimetroInicial(horimetro)
        } else {
            boletimFertDatasourceSharedPreferences.setHorimetroInicial(horimetro)
        }
        if(!check) return check
        return equipRepository.updateHorimetroEquip(horimetro)
    }

    override suspend fun setIdAtivBoletimMMFert(idAtiv: Long): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.setIdAtiv(idAtiv)
        } else {
            boletimFertDatasourceSharedPreferences.setIdAtiv(idAtiv)
        }
    }

    override suspend fun setMatricFuncBoletimMMFert(matricOperador: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.setMatricOperador(matricOperador.toLong())
        } else {
            boletimFertDatasourceSharedPreferences.setMatricOperador(matricOperador.toLong())
        }
    }

    override suspend fun setIdTurnoBoletimMMFert(idTurno: Long): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.setIdTurno(idTurno)
        } else {
            boletimFertDatasourceSharedPreferences.setIdTurno(idTurno)
        }
    }

    override suspend fun setNroOSBoletimMMFert(nroOS: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.setNroOS(nroOS.toLong())
        } else {
            boletimFertDatasourceSharedPreferences.setNroOS(nroOS.toLong())
        }
    }

    override suspend fun setStatusEnviarBoletimMM(idBol: Long): Boolean {
        return boletimMMDatasourceRoom.setStatusEnviar(idBol)
    }

    override suspend fun startBoletimMMFert(): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.startBoletim(equipRepository.getEquip().idEquip)
        } else {
            boletimFertDatasourceSharedPreferences.startBoletim(equipRepository.getEquip().idEquip)
        }
    }

}