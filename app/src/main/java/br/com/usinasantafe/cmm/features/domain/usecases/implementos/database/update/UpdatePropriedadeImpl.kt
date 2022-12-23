package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.PropriedadeRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdatePropriedade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePropriedadeImpl @Inject constructor(
    private val propriedadeRepository: PropriedadeRepository
): UpdatePropriedade {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdatePropriedade = contador
            emit(ResultUpdateDataBase(++contUpdatePropriedade,"Limpando Dados da Tabela Propriedade", qtde))
            propriedadeRepository.deleteAllPropriedade()
            emit(ResultUpdateDataBase(++contUpdatePropriedade,"Recebendo Dados da Tabela Propriedade", qtde))
            propriedadeRepository.recoverAllPropriedade()
                .collect{ result ->
                    result.onSuccess { propriedadeList ->
                        emit(ResultUpdateDataBase(++contUpdatePropriedade,"Salvandos Dados da Tabela Propriedade", qtde))
                        propriedadeRepository.addAllPropriedade(propriedadeList)
                    }
                }
        }
    }

}