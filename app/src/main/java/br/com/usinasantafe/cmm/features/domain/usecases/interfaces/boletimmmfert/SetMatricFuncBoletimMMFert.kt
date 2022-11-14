package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface SetMatricFuncBoletimMMFert {

    suspend operator fun invoke(matricOperador: String): Boolean

}