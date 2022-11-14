package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Pneu
import br.com.usinasantafe.cmm.features.infra.models.toPneu
import br.com.usinasantafe.cmm.features.infra.models.toPneuModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PneuRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.PneuDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.PneuDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PneuRepositoryImpl @Inject constructor(
    private val pneuDatasourceRoom: PneuDatasourceRoom,
    private val pneuDatasourceWebService: PneuDatasourceWebService
): PneuRepository {

    override suspend fun addAllPneu(pneuList: List<Pneu>) {
        for(pneu in pneuList){
            val pneuModel = pneu.toPneuModel()
            pneuDatasourceRoom.addPneu(pneuModel)
        }
    }

    override suspend fun deleteAllPneu() {
        pneuDatasourceRoom.deleteAllPneu()
    }

    override suspend fun getAllPneu(): Flow<Result<List<Pneu>>> {
        return flow {
            pneuDatasourceWebService.getAllPneu()
                .collect { result ->
                    result.onSuccess {pneuModelList ->
                        val pneuList = mutableListOf<Pneu>()
                        for (pneuModel in pneuModelList){
                            pneuList.add(pneuModel.toPneu())
                        }
                        emit(Result.success(pneuList))
                    }
                }
        }
    }

}