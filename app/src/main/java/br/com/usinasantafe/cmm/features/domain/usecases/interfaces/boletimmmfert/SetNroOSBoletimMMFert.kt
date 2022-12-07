package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface SetNroOSBoletimMMFert {

    suspend operator fun invoke(nroOS: String): Boolean

}