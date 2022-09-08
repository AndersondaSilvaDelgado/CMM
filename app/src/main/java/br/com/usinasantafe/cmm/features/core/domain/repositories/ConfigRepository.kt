package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Config

interface ConfigRepository {

    suspend fun addConfig(config: Config)

    suspend fun hasElementConfig(): Boolean

    suspend fun deleteAllConfig()

    suspend fun getConfig(): Config

    suspend fun getConfig(senha: String): Config

}