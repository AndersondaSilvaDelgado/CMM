package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetHorimetroEquip
import javax.inject.Inject

class GetHorimetroEquipImpl @Inject constructor (
    private val equipRepository: EquipRepository
): GetHorimetroEquip {

    override suspend fun invoke(): String {
        return equipRepository.getEquip().horimetroEquip.toString().replace(".", ",")
    }

}