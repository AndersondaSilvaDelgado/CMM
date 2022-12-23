package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateParadaImpl @Inject constructor(
    private val paradaRepository: ParadaRepository
): UpdateParada {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateParada = contador
            emit(ResultUpdateDataBase(++contUpdateParada,"Limpando Dados da Tabela Parada", qtde))
            paradaRepository.deleteAllParada()
            emit(ResultUpdateDataBase(++contUpdateParada,"Recebendo Dados da Tabela Parada", qtde))
            paradaRepository.recoverAllParada()
                .collect{ result ->
                    result.onSuccess { paradaList ->
                        emit(ResultUpdateDataBase(++contUpdateParada,"Salvandos Dados da Tabela Parada", qtde))
                        paradaRepository.addAllParada(paradaList)
                    }
                }
        }
    }

}