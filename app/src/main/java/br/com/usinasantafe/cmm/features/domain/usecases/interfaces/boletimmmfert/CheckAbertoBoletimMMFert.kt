package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

interface CheckAbertoBoletimMMFert {

    suspend operator fun invoke(): Boolean

}