package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface CheckOpenBoletimMMFert {

    suspend operator fun invoke(): Boolean

}