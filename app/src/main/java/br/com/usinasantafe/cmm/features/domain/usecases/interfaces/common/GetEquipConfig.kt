package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.Equip

interface GetEquipConfig {

    suspend operator fun invoke(): Equip

}