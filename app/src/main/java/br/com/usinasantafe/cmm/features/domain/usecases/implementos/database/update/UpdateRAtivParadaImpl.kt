package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.RAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateRAtivParadaImpl @Inject constructor(
    private val rAtivParadaRepository: RAtivParadaRepository
): UpdateRAtivParada {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateRAtivParada = contador
            emit(ResultUpdateDataBase(++contUpdateRAtivParada, "Limpando Dados da Tabela RAtivParada", qtde))
            rAtivParadaRepository.deleteAllRAtivParada()
            emit(ResultUpdateDataBase(++contUpdateRAtivParada,"Recebendo Dados da Tabela RAtivParada", qtde))
            rAtivParadaRepository.recoverAllRAtivParada()
                .collect{ result ->
                    result.onSuccess { rAtivParadaList ->
                        emit(ResultUpdateDataBase(++contUpdateRAtivParada,"Salvandos Dados da Tabela RAtivParada", qtde))
                        rAtivParadaRepository.addAllRAtivParada(rAtivParadaList)
                    }
                }
        }
    }

}