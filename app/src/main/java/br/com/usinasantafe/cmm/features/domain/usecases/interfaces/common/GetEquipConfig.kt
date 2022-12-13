package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip

interface GetEquipConfig {

    suspend operator fun invoke(): Equip

}