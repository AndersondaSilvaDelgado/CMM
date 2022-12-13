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

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Propriedade", size))
            propriedadeRepository.deleteAllPropriedade()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Propriedade", size))
            propriedadeRepository.recoverAllPropriedade()
                .collect{ result ->
                    result.onSuccess { propriedadeList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Propriedade", size))
                        propriedadeRepository.addAllPropriedade(propriedadeList)
                    }
                }
        }
    }

}