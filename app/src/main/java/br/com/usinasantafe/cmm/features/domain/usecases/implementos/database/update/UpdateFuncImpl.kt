package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.FuncRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateFunc
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateFuncImpl @Inject constructor(
    private val funcRepository: FuncRepository
): UpdateFunc {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateFunc = contador
            emit(ResultUpdateDataBase(++contUpdateFunc, "Limpando Dados da Tabela Func", qtde))
            funcRepository.deleteAllFunc()
            emit(ResultUpdateDataBase(++contUpdateFunc,"Recebendo Dados da Tabela Func", qtde))
            funcRepository.recoverAllFunc()
                .collect{ result ->
                    result.onSuccess { funcList ->
                        emit(ResultUpdateDataBase(++contUpdateFunc,"Salvandos Dados da Tabela Func", qtde))
                        funcRepository.addAllFunc(funcList)
                    }
                }
        }
    }

}