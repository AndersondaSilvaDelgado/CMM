package br.com.usinasantafe.cmm.features.domain.usecases.implementos.manipulationdata

import br.com.usinasantafe.cmm.features.domain.repositories.stable.FuncRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata.UpdateFunc
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateFuncImpl @Inject constructor(
    private val funcRepository: FuncRepository
): UpdateFunc {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela Func", size))
            funcRepository.deleteAllFunc()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Func", size))
            funcRepository.recoverAllFunc()
                .collect{ result ->
                    result.onSuccess { funcList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Func", size))
                        funcRepository.addAllFunc(funcList)
                    }
                }
        }
    }

}