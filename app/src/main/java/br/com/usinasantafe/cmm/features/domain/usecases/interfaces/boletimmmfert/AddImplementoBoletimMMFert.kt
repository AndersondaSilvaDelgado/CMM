package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface AddImplementoBoletimMMFert {

    suspend operator fun invoke(nroEquip: String): Boolean

}