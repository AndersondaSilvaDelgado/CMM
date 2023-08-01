package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert

interface AddImplemento {

    suspend operator fun invoke(nroEquip: String): Boolean

}