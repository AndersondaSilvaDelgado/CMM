package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.PressaoBocal
import kotlinx.coroutines.flow.Flow

interface PressaoBocalRepository {

    suspend fun addAllPressaoBocal(pressaoBocalList: List<PressaoBocal>)

    suspend fun deleteAllPressaoBocal()

    suspend fun recoverAllPressaoBocal(): Flow<Result<List<PressaoBocal>>>

}