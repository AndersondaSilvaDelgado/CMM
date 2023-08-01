package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ApontFertDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ApontMMDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.toApontFertRoomModel
import br.com.usinasantafe.cmm.features.infra.models.room.variable.toApontMMRoomModel
import javax.inject.Inject

class ApontMMFertRepositoryImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val apontFertDatasourceSharedPreferences: ApontFertDatasourceSharedPreferences,
    private val apontMMDatasourceSharedPreferences: ApontMMDatasourceSharedPreferences,
    private val apontFertDatasourceRoom: ApontFertDatasourceRoom,
    private val apontMMDatasourceRoom: ApontMMDatasourceRoom,
    private val boletimMMDatasourceRoom: BoletimMMDatasourceRoom,
    private val boletimFertDatasourceRoom: BoletimFertDatasourceRoom
) : ApontMMFertRepository {

    override suspend fun checkApontMMFertSend(): Boolean {
        return apontMMDatasourceRoom.checkApontMMSend()
    }

    override suspend fun getIdAtivApontMMFert(): Long {
        return apontMMDatasourceSharedPreferences.getApontMM().idAtivApont!!
    }

    override suspend fun getNroOSApontMMFert(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceSharedPreferences.getApontMM().nroOSApont!!
        } else {
            apontFertDatasourceSharedPreferences.getApontFert().nroOSApont!!
        }
    }

    override suspend fun getTipoMMFert(): TypeNote {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceSharedPreferences.getApontMM().tipoApont!!
        } else {
            apontFertDatasourceSharedPreferences.getApontFert().tipoApont!!
        }
    }

    override suspend fun setIdAtivApontMMFert(idAtiv: Long): Boolean {
        if (equipRepository.getEquip().tipoEquip == 1L) {
            var ret = apontMMDatasourceSharedPreferences.setIdAtiv(idAtiv)
            return if(!ret){
                false
            } else {
                if(apontMMDatasourceSharedPreferences.getApontMM().tipoApont == TypeNote.TRABALHANDO){
                    apontMMDatasourceRoom.insertApontMM(apontMMDatasourceSharedPreferences.getApontMM().toApontMMRoomModel())
                } else {
                    true
                }
            }
        } else {
            var ret = apontFertDatasourceSharedPreferences.setIdParada(idAtiv)
            return if(!ret){
                false
            } else {
                if(apontMMDatasourceSharedPreferences.getApontMM().tipoApont == TypeNote.TRABALHANDO){
                    apontFertDatasourceRoom.insertApontFert(apontFertDatasourceSharedPreferences.getApontFert().toApontFertRoomModel())
                } else {
                    true
                }
            }
        }
    }

    override suspend fun setIdParadaApontMMFert(idParada: Long): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            var ret = apontMMDatasourceSharedPreferences.setIdParada(idParada)
            if(!ret){
                false
            } else {
                apontMMDatasourceRoom.insertApontMM(apontMMDatasourceSharedPreferences.getApontMM().toApontMMRoomModel())
            }
        } else {
            var ret = apontFertDatasourceSharedPreferences.setIdParada(idParada)
            if(!ret){
                false
            } else {
                apontFertDatasourceRoom.insertApontFert(apontFertDatasourceSharedPreferences.getApontFert().toApontFertRoomModel())
            }
        }
    }

    override suspend fun setNroOSApontMMFert(nroOS: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceSharedPreferences.setNroOS(nroOS.toLong())
        } else {
            apontFertDatasourceSharedPreferences.setNroOS(nroOS.toLong())
        }
    }

    override suspend fun startApontMMFert(typeNote: TypeNote, nroOS: Long?, idAtiv: Long?): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceSharedPreferences.startApont(typeNote, boletimMMDatasourceRoom.getBoletimAbertoMM().idBolMM!!, nroOS, idAtiv)
        } else {
            apontFertDatasourceSharedPreferences.startApont(typeNote, boletimFertDatasourceRoom.getBoletimAbertoFert().idBolFert!!, nroOS, idAtiv)
        }
    }

}