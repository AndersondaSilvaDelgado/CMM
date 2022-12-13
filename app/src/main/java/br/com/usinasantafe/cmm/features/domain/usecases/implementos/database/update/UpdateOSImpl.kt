package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateOSImpl @Inject constructor(
    private val osRepository: OSRepository
): UpdateOS {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela OS", size))
            osRepository.deleteAllOS()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela OS", size))
            osRepository.recoverAllOS()
                .collect{ result ->
                    result.onSuccess { osList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela OS", size))
                        osRepository.addAllOS(osList)
                    }
                }
        }
    }

}