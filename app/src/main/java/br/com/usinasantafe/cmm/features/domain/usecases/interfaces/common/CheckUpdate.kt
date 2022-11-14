package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface CheckUpdate {

    suspend operator fun invoke(): Boolean

}