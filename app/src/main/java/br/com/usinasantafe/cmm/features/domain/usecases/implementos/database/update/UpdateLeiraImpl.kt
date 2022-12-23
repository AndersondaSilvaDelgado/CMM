package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.LeiraRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateLeira
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateLeiraImpl @Inject constructor(
    private val leiraRepository: LeiraRepository
): UpdateLeira {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateLeira = contador
            emit(ResultUpdateDataBase(++contUpdateLeira, "Limpando Dados da Tabela Leira", qtde))
            leiraRepository.deleteAllLeira()
                    emit(ResultUpdateDataBase(++contUpdateLeira,"Recebendo Dados da Tabela Leira", qtde))
            leiraRepository.recoverAllLeira()
                .collect{ result ->
                    result.onSuccess { leiraList ->
                        emit(ResultUpdateDataBase(++contUpdateLeira,"Salvandos Dados da Tabela Leira", qtde))
                        leiraRepository.addAllLeira(leiraList)
                    }
                }
        }
    }

}