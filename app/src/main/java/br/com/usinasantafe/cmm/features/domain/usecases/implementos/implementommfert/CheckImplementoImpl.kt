package br.com.usinasantafe.cmm.features.domain.usecases.implementos.implementommfert

import br.com.usinasantafe.cmm.common.utils.StatusImplemento
import br.com.usinasantafe.cmm.common.utils.TYPE_EQUIP_SEG_TRANSBORDO
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipSegRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.CheckImplemento
import javax.inject.Inject

class CheckImplementoImpl @Inject constructor (
    private val equipSegRepository: EquipSegRepository,
    private val implementoRepository: ImplementoRepository,
): CheckImplemento {

    override suspend fun invoke(nroEquip: String): StatusImplemento {
        if(implementoRepository.countImplemento() > 0){
            var listImplemento = implementoRepository.listImplemento()
            var implementoRepeated = false
            listImplemento.map { implemento ->
                if(implemento.codEquip == nroEquip.toLong()){
                    implementoRepeated = true
                }
            }
            if(implementoRepeated){
                return StatusImplemento.REPETIDO
            }
        }
        return if(equipSegRepository.checkEquipSeg(nroEquip.toLong(), TYPE_EQUIP_SEG_TRANSBORDO)){
            StatusImplemento.OK
        } else {
            StatusImplemento.INEXISTENTE
        }
    }

}