package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.SetHorimetroEquip
import javax.inject.Inject

class SetHorimetroEquipImpl @Inject constructor(
): SetHorimetroEquip {

    override suspend fun invoke(horimetro: String): Boolean {
        TODO("Not yet implemented")
    }

}