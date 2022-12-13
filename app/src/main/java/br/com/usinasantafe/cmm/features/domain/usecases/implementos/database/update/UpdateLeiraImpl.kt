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

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela Leira", size))
            leiraRepository.deleteAllLeira()
                    emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Leira", size))
            leiraRepository.recoverAllLeira()
                .collect{ result ->
                    result.onSuccess { leiraList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Leira", size))
                        leiraRepository.addAllLeira(leiraList)
                    }
                }
        }
    }

}