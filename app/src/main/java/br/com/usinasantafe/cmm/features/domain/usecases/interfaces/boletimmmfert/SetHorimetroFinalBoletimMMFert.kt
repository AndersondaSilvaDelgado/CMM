package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface SetHorimetroFinalBoletimMMFert {

    suspend operator fun invoke(horimetroFinal: String): Boolean

}