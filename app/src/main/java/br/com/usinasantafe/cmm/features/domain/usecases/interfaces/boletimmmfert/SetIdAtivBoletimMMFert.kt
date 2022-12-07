package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface SetIdAtivBoletimMMFert {

    suspend operator fun invoke(idAtiv: Long): Boolean

}