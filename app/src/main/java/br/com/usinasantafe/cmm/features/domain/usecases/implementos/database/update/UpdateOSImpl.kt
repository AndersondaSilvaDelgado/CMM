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

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateOS = contador
            emit(ResultUpdateDataBase(++contUpdateOS,"Limpando Dados da Tabela OS", qtde))
            osRepository.deleteAllOS()
            emit(ResultUpdateDataBase(++contUpdateOS,"Recebendo Dados da Tabela OS", qtde))
            osRepository.recoverAllOS()
                .collect{ result ->
                    result.onSuccess { osList ->
                        emit(ResultUpdateDataBase(++contUpdateOS,"Salvandos Dados da Tabela OS", qtde))
                        osRepository.addAllOS(osList)
                    }
                }
        }
    }

}