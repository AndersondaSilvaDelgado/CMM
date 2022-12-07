package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdEquipBoletimMMFert
import javax.inject.Inject

class SetIdEquipBoletimMMFertImpl @Inject constructor(
    private val configRepository: ConfigRepository,
    private val equipRepository: EquipRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository
): SetIdEquipBoletimMMFert {

    override suspend fun invoke(): Boolean {
        return boletimMMFertRepository.setIdEquipBoletimMMFert(equipRepository.getEquipNro(configRepository.getConfig().equipConfig).idEquip)
    }

}