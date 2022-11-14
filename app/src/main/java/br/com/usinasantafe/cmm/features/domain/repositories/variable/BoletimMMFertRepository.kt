package br.com.usinasantafe.cmm.features.domain.repositories.variable

interface BoletimMMFertRepository {

    suspend fun startBoletimMMFert(): Boolean

}