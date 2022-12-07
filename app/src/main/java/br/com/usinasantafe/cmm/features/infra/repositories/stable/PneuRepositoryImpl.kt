package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Pneu
import br.com.usinasantafe.cmm.features.infra.models.toPneu
import br.com.usinasantafe.cmm.features.infra.models.toPneuModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PneuRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.PneuDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.PneuDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toParadaModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PneuRepositoryImpl @Inject constructor(
    private val pneuDatasourceRoom: PneuDatasourceRoom,
    private val pneuDatasourceWebService: PneuDatasourceWebService
): PneuRepository {

    override suspend fun addAllPneu(pneuList: List<Pneu>) {
        pneuDatasourceRoom.addAllPneu(*pneuList.map { it.toPneuModel() }.toTypedArray())
    }

    override suspend fun deleteAllPneu() {
        pneuDatasourceRoom.deleteAllPneu()
    }

    override suspend fun recoverAllPneu(): Flow<Result<List<Pneu>>> {
        return flow {
            pneuDatasourceWebService.getAllPneu()
                .collect { result ->
                    result.onSuccess {pneuModelList ->
                        emit(Result.success(pneuModelList.map { it.toPneu() }))
                    }
                }
        }
    }

}