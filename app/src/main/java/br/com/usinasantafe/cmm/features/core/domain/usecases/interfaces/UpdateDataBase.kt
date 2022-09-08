package br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces

interface UpdateDataBase {

    suspend fun updateAtividade()

    suspend fun updateBocal()

    suspend fun updateComponente()

    suspend fun updateEquipSeg()

    suspend fun updateFrente()

    suspend fun updateFunc()

    suspend fun updateItemCheckList()

    suspend fun updateItemOSMecan()

    suspend fun updateLeira()

    suspend fun updateMotoMec()

    suspend fun updateOS()

    suspend fun updateParada()

    suspend fun updatePneu()

    suspend fun updatePressaoBocal()

    suspend fun updateProduto()

    suspend fun updatePropriedade()

    suspend fun updateRAtivParada()

    suspend fun updateRFuncaoAtivParada()

    suspend fun updateROSAtiv()

    suspend fun updateServico()

    suspend fun updateTurnoParada()

}