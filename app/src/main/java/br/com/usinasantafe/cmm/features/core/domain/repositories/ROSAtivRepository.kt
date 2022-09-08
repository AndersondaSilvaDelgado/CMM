package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.ROSAtiv

interface ROSAtivRepository {

    suspend fun addAllROSAtiv(rOSAtivList: List<ROSAtiv>)

    suspend fun deleteAllROSAtiv()

    suspend fun getAllROSAtiv(): List<ROSAtiv>

}