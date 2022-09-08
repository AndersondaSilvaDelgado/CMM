package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.MotoMec

interface MotoMecRepository {

    suspend fun addAllMotoMec(motoMecList: List<MotoMec>)

    suspend fun deleteAllMotoMec()

    suspend fun getAllMotoMec(): List<MotoMec>

}