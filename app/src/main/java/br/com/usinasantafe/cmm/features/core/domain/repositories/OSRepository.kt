package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.OS

interface OSRepository {

    suspend fun addAllOS(osList: List<OS>)

    suspend fun deleteAllOS()

    suspend fun getAllOS(): List<OS>

}