package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ServicoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateServico
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateServicoImpl @Inject constructor(
    private val servicoRepository: ServicoRepository
): UpdateServico {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateServico = contador
            emit(ResultUpdateDataBase(++contUpdateServico,"Limpando Dados da Tabela Servico", qtde))
            servicoRepository.deleteAllServico()
            emit(ResultUpdateDataBase(++contUpdateServico,"Recebendo Dados da Tabela Servico", qtde))
            servicoRepository.recoverAllServico()
                .collect{ result ->
                    result.onSuccess { servicoList ->
                        emit(ResultUpdateDataBase(++contUpdateServico,"Salvandos Dados da Tabela Servico", qtde))
                        servicoRepository.addAllServico(servicoList)
                    }
                }
        }
    }

}