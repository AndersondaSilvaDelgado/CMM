package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Servico
import br.com.usinasantafe.cmm.features.infra.models.toServico
import br.com.usinasantafe.cmm.features.infra.models.toServicoModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ServicoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ServicoDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ServicoDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toROSAtivModel
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