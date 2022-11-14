package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.PressaoBocal
import br.com.usinasantafe.cmm.features.infra.models.toPressaoBocal
import br.com.usinasantafe.cmm.features.infra.models.toPressaoBocalModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PressaoBocalRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.PressaoBocalDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.PressaoBocalDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PressaoBocalRepositoryImpl @Inject constructor(
    private val pressaoBocalDatasourceRoom: PressaoBocalDatasourceRoom,
    private val pressaoBocalDatasourceWebService: PressaoBocalDatasourceWebService
): PressaoBocalRepository {

    override suspend fun addAllPressaoBocal(pressaoBocalList: List<PressaoBocal>) {
        for(pressaoBocal in pressaoBocalList){
            val pressaoBocalModel = pressaoBocal.toPressaoBocalModel()
            pressaoBocalDatasourceRoom.addPressaoBocal(pressaoBocalModel)
        }
    }

    override suspend fun deleteAllPressaoBocal() {
        pressaoBocalDatasourceRoom.deleteAllPressaoBocal()
    }

    override suspend fun getAllPressaoBocal(): Flow<Result<List<PressaoBocal>>> {
        return flow {
            pressaoBocalDatasourceWebService.getAllPressaoBocal()
                .collect { result ->
                    result.onSuccess {pressaoBocalModelList ->
                        val pressaoBocalList = mutableListOf<PressaoBocal>()
                        for (pressaoBocalModel in pressaoBocalModelList){
                            pressaoBocalList.add(pressaoBocalModel.toPressaoBocal())
                        }
                        emit(Result.success(pressaoBocalList))
                    }
                }
        }
    }

}