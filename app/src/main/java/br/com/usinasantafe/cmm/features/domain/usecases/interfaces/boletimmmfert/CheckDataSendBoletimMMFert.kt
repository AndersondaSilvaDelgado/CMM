package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface CheckDataSendBoletimMMFert {

    suspend operator fun invoke(): Boolean

}