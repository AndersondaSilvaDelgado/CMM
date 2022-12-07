package br.com.usinasantafe.cmm.features.domain.usecases.implementos.manipulationdata

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ServicoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata.UpdateServico
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateServicoImpl @Inject constructor(
    private val servicoRepository: ServicoRepository
): UpdateServico {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Servico", size))
            servicoRepository.deleteAllServico()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Servico", size))
            servicoRepository.recoverAllServico()
                .collect{ result ->
                    result.onSuccess { servicoList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Servico", size))
                        servicoRepository.addAllServico(servicoList)
                    }
                }
        }
    }

}