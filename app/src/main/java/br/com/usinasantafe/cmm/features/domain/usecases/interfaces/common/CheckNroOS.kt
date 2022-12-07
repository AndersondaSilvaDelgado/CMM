package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface CheckNroOS {

    suspend operator fun invoke(nroOS: String): Boolean

}