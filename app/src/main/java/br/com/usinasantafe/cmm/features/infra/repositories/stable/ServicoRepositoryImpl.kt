package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Servico
import br.com.usinasantafe.cmm.features.infra.models.toServico
import br.com.usinasantafe.cmm.features.infra.models.toServicoModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ServicoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ServicoDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ServicoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServicoRepositoryImpl @Inject constructor(
    private val servicoDatasourceRoom: ServicoDatasourceRoom,
    private val servicoDatasourceWebService: ServicoDatasourceWebService
): ServicoRepository {

    override suspend fun addAllServico(servicoList: List<Servico>) {
        for(servico in servicoList){
            val servicoModel = servico.toServicoModel()
            servicoDatasourceRoom.addServico(servicoModel)
        }
    }

    override suspend fun deleteAllServico() {
        servicoDatasourceRoom.deleteAllServico()
    }

    override suspend fun getAllServico(): Flow<Result<List<Servico>>> {
        return flow {
            servicoDatasourceWebService.getAllServico()
                .collect { result ->
                    result.onSuccess {servicoModelList ->
                        val servicoList = mutableListOf<Servico>()
                        for (servicoModel in servicoModelList){
                            servicoList.add(servicoModel.toServico())
                        }
                        emit(Result.success(servicoList))
                    }
                }
        }
    }

}