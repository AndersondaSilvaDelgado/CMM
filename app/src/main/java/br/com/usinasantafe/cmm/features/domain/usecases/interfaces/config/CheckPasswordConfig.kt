package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config

interface CheckPasswordConfig {

    suspend operator fun invoke(senha: String): Boolean

}