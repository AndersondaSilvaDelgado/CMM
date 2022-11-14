package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface CheckMatricOperador {

    suspend operator fun invoke(matricFunc: String): Boolean

}