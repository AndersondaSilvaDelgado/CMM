package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface SetHorimetroFinishBoletimMMFert {

    suspend operator fun invoke(horimetroFinal: String): Boolean

}