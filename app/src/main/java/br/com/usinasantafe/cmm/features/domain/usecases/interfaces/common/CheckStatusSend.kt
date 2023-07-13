package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface CheckStatusSend {

    suspend operator fun invoke(): Boolean

}