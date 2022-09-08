package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Propriedade

interface PropriedadeRepository {

    suspend fun addAllPropriedade(propriedadeList: List<Propriedade>)

    suspend fun deleteAllPropriedade()

    suspend fun getAllPropriedade(): List<Propriedade>

}