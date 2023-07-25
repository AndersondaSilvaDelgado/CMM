package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckHorimetroBoletimMMFert
import javax.inject.Inject

class CheckHorimetroBoletimMMFertImpl @Inject constructor(
    private val equipRepository: EquipRepository
): CheckHorimetroBoletimMMFert {

    override suspend fun invoke(horimetro: String): Boolean {
        return equipRepository.getEquip().horimetroEquip < horimetro.replace(",", ".").toDouble()
    }

}