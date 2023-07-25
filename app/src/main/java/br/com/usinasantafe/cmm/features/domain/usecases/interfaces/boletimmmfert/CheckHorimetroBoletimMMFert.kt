package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface CheckHorimetroBoletimMMFert {

    suspend operator fun invoke(horimetro: String): Boolean

}