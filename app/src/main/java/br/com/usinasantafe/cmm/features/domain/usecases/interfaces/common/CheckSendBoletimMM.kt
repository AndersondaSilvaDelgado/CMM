package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface CheckSendBoletimMM {

    suspend operator fun invoke(): Boolean

}