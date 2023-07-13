package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetEquipConfig
import javax.inject.Inject

class GetEquipConfigImpl @Inject constructor (
    private val equipRepository: EquipRepository
): GetEquipConfig {

    override suspend fun invoke(): Equip {
        return equipRepository.getEquip()
    }

}