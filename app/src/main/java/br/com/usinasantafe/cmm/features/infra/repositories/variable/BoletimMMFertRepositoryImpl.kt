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
import br.com.usinasantafe.cmm.features.infra.models.variable.room.*
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
        return boletimMMDatasourceRoom.checkBoletimAbertoMM() || boletimFertDatasourceRoom.checkBoletimAbertoFert()
    }

    override suspend fun checkBoletimSend(): Boolean {
        return boletimMMDatasourceRoom.checkBoletimMMSend()
    }

    override suspend fun finishBoletimMMFert(): Boolean {
        return boletimMMDatasourceRoom.finishBoletimMM(boletimMMDatasourceRoom.getBoletimAbertoMM())
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
            boletimMMDatasourceSharedPreferences.getBoletimMM().nroOSBol!!
        } else {
            boletimFertDatasourceSharedPreferences.getBoletimFert().nroOSBol!!
        }
    }

    override suspend fun insertBoletimMMFert(): Boolean {
        var ret = if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceRoom.insertBoletimMM(boletimMMDatasourceSharedPreferences.getBoletimMM().toBoletimMMRoomModel())
        } else {
            boletimFertDatasourceRoom.insertBoletimFert(boletimFertDatasourceSharedPreferences.getBoletimFert().toBoletimFertRoomModel())
        }
        return ret
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
       return boletimMMDatasourceRoom.setHorimetroFinal(
           horimetroFinal.replace(",", ".").toDouble()
        )
    }

    override suspend fun setHorimetroInicialBoletimMMFert(horimetroInicial: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            boletimMMDatasourceSharedPreferences.setHorimetroInicial(
                horimetroInicial.replace(",", ".").toDouble()
            )
        } else {
            boletimFertDatasourceSharedPreferences.setHorimetroInicial(
                horimetroInicial.replace(",", ".").toDouble()
            )
        }
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