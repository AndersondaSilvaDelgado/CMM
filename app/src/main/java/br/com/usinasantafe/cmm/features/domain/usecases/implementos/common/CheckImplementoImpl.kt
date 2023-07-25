package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.common.utils.TYPE_EQUIP_SEG_TRANSBORDO
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipSegRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckImplemento
import javax.inject.Inject

class CheckImplementoImpl @Inject constructor (
    private val equipSegRepository: EquipSegRepository
): CheckImplemento {

    override suspend fun invoke(nroEquip: String): Boolean {
        return equipSegRepository.checkEquipSeg(nroEquip.toLong(), TYPE_EQUIP_SEG_TRANSBORDO)
    }

}