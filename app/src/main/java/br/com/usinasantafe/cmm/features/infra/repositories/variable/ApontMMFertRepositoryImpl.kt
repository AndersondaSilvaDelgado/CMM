package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontFertDatasourceMemory
import br.com.usinasantafe.cmm.features.infra.datasource.memory.ApontMMDatasourceMemory
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.toApontFertRoomModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.toApontMMRoomModel
import javax.inject.Inject

class ApontMMFertRepositoryImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val apontFertDatasourceMemory: ApontFertDatasourceMemory,
    private val apontMMDatasourceMemory: ApontMMDatasourceMemory,
    private val apontFertDatasourceRoom: ApontFertDatasourceRoom,
    private val apontMMDatasourceRoom: ApontMMDatasourceRoom,
    private val boletimMMDatasourceRoom: BoletimMMDatasourceRoom,
    private val boletimFertDatasourceRoom: BoletimFertDatasourceRoom
) : ApontMMFertRepository {

    override suspend fun getOS(): Long {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceMemory.getApontMM().nroOSApont!!
        } else {
            apontFertDatasourceMemory.getApontFert().nroOSApont!!
        }
    }

    override suspend fun getTipo(): TypeNote {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceMemory.getApontMM().tipoApont
        } else {
            apontFertDatasourceMemory.getApontFert().tipoApont
        }
    }

    override suspend fun setIdAtivApontMMFert(idAtiv: Long): Boolean {
        if (equipRepository.getEquip().tipoEquip == 1L) {
            var ret = apontMMDatasourceMemory.setIdAtiv(idAtiv)
            return if(!ret){
                false
            } else {
                if(apontMMDatasourceMemory.getApontMM().tipoApont == TypeNote.TRABALHANDO){
                    apontMMDatasourceRoom.insertApontMM(apontMMDatasourceMemory.getApontMM().toApontMMRoomModel())
                } else {
                    true
                }
            }
        } else {
            var ret = apontFertDatasourceMemory.setIdParada(idAtiv)
            return if(!ret){
                false
            } else {
                if(apontMMDatasourceMemory.getApontMM().tipoApont == TypeNote.TRABALHANDO){
                    apontFertDatasourceRoom.insertApontFert(apontFertDatasourceMemory.getApontFert().toApontFertRoomModel())
                } else {
                    true
                }
            }
        }
    }

    override suspend fun setIdParadaApontMMFert(idParada: Long): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            var ret = apontMMDatasourceMemory.setIdParada(idParada)
            if(!ret){
                false
            } else {
                apontMMDatasourceRoom.insertApontMM(apontMMDatasourceMemory.getApontMM().toApontMMRoomModel())
            }
        } else {
            var ret = apontFertDatasourceMemory.setIdParada(idParada)
            if(!ret){
                false
            } else {
                apontFertDatasourceRoom.insertApontFert(apontFertDatasourceMemory.getApontFert().toApontFertRoomModel())
            }
        }
    }

    override suspend fun setNroOSApontMMFert(nroOS: String): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceMemory.setNroOS(nroOS.toLong())
        } else {
            apontFertDatasourceMemory.setNroOS(nroOS.toLong())
        }
    }

    override suspend fun startApontMMFert(typeNote: TypeNote): Boolean {
        return if (equipRepository.getEquip().tipoEquip == 1L) {
            apontMMDatasourceMemory.startApont(typeNote, boletimMMDatasourceRoom.getBoletimAbertoMM().idBolMM!!)
        } else {
            apontFertDatasourceMemory.startApont(typeNote, boletimFertDatasourceRoom.getBoletimAbertoFert().idBolFert!!)
        }
    }

}