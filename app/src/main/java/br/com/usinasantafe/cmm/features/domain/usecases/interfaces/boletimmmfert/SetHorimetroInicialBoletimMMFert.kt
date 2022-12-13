package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface SetHorimetroInicialBoletimMMFert {

    suspend operator fun invoke(horimetroInicial: String): Boolean

}