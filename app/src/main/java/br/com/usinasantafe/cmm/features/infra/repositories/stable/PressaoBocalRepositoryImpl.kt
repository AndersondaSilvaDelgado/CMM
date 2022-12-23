package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.PressaoBocal
import br.com.usinasantafe.cmm.features.infra.models.stable.toPressaoBocal
import br.com.usinasantafe.cmm.features.infra.models.stable.toPressaoBocalModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PressaoBocalRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.PressaoBocalDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.PressaoBocalDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PressaoBocalRepositoryImpl @Inject constructor(
    private val pressaoBocalDatasourceRoom: PressaoBocalDatasourceRoom,
    private val pressaoBocalDatasourceWebService: PressaoBocalDatasourceWebService
): PressaoBocalRepository {

    override suspend fun addAllPressaoBocal(pressaoBocalList: List<PressaoBocal>) {
        pressaoBocalDatasourceRoom.addAllPressaoBocal(*pressaoBocalList.map { it.toPressaoBocalModel() }.toTypedArray())
    }

    override suspend fun deleteAllPressaoBocal() {
        pressaoBocalDatasourceRoom.deleteAllPressaoBocal()
    }

    override suspend fun recoverAllPressaoBocal(): Flow<Result<List<PressaoBocal>>> {
        return flow {
            pressaoBocalDatasourceWebService.getAllPressaoBocal()
                .collect { result ->
                    result.onSuccess {pressaoBocalModelList ->
                        emit(Result.success(pressaoBocalModelList.map { it.toPressaoBocal() }))
                    }
                }
        }
    }

}