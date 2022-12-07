package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface SetIdTurnoBoletimMMFert {

    suspend operator fun invoke(idTurno: Long): Boolean

}