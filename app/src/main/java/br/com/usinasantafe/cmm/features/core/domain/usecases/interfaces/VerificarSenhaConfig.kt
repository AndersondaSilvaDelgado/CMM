package br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces

interface VerificarSenhaConfig {

    suspend operator fun invoke(senha: String): Boolean

}