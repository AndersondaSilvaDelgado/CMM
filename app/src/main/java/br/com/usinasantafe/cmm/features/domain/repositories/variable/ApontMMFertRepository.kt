package br.com.usinasantafe.cmm.features.domain.repositories.variable

interface ApontMMFertRepository {

    suspend fun startApontMMFert(tipo: Long): Boolean

}