package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config

interface HasConfig {

    suspend operator fun invoke(): Boolean

}