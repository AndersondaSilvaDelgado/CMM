package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.Config

interface ConfigRepository {

    suspend fun hasSenhaConfig(): Boolean

    suspend fun getSenhaConfig(): String

    suspend fun getConfig(): Config

    suspend fun saveConfig(nroEquip: String, senha: String)

}