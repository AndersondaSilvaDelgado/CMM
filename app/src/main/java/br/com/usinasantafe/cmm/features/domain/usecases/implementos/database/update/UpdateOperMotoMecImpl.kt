package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.OperMotoMecRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateOperMotoMec
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateOperMotoMecImpl @Inject constructor(
    private val operMotoMecRepository: OperMotoMecRepository
): UpdateOperMotoMec {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateMotoMec = contador
            emit(ResultUpdateDataBase(++contUpdateMotoMec,"Limpando Dados da Tabela MotoMec", qtde))
            operMotoMecRepository.deleteAllOperMotoMec()
            emit(ResultUpdateDataBase(++contUpdateMotoMec,"Recebendo Dados da Tabela MotoMec", qtde))
            operMotoMecRepository.recoverAllOperMotoMec()
                .collect{ result ->
                    result.onSuccess { motoMecList ->
                        emit(ResultUpdateDataBase(++contUpdateMotoMec,"Salvandos Dados da Tabela MotoMec", qtde))
                        operMotoMecRepository.addAllOperMotoMec(motoMecList)
                    }
                }
        }
    }

}