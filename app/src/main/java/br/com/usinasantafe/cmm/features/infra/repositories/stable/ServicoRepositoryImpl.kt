package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Servico
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toServico
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toServicoModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ServicoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ServicoDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ServicoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServicoRepositoryImpl @Inject constructor(
    private val servicoDatasourceRoom: ServicoDatasourceRoom,
    private val servicoDatasourceWebService: ServicoDatasourceWebService
): ServicoRepository {

    override suspend fun addAllServico(servicoList: List<Servico>) {
        servicoDatasourceRoom.addAllServico(*servicoList.map { it.toServicoModel() }.toTypedArray())
    }

    override suspend fun deleteAllServico() {
        servicoDatasourceRoom.deleteAllServico()
    }

    override suspend fun recoverAllServico(): Flow<Result<List<Servico>>> {
        return flow {
            servicoDatasourceWebService.getAllServico()
                .collect { result ->
                    result.onSuccess {servicoModelList ->
                        emit(Result.success(servicoModelList.map { it.toServico() }))
                    }
                }
        }
    }

}