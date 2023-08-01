package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList

interface CabecCheckListRepository {

    suspend fun closeCabecCheckList(): Boolean

    suspend fun getIdCabecCheckListAberto(): Long

    suspend fun openCabecCheckList(): Boolean

    suspend fun receiverSentCabecCheckList(cabecCheckListList: List<CabecCheckList>)

    suspend fun sendCheckList(): Result<List<CabecCheckList>>

}