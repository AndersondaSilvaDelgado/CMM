package br.com.usinasantafe.cmm.features.domain.repositories.variable

interface CabecCheckListRepository {

    suspend fun idCabecCheckListAberto(): Long

    suspend fun openCabecCheckList()

}