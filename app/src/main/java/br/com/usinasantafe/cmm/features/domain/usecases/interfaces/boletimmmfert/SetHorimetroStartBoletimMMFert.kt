package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

import br.com.usinasantafe.cmm.common.utils.ChoiceHorimetro

interface SetHorimetroStartBoletimMMFert {

    suspend operator fun invoke(horimetroInicial: String): ChoiceHorimetro

}