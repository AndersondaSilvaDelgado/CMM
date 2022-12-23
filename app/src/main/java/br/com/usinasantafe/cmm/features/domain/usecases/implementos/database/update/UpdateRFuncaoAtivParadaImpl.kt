package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateRFuncaoAtivParadaImpl @Inject constructor(
    private val rFuncaoAtivParadaRepository: RFuncaoAtivParadaRepository
): UpdateRFuncaoAtivParada {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateRFuncaoAtivParada = contador
            emit(ResultUpdateDataBase(++contUpdateRFuncaoAtivParada,"Limpando Dados da Tabela RFuncaoAtivParada", qtde))
            rFuncaoAtivParadaRepository.deleteAllRFuncaoAtivParada()
            emit(ResultUpdateDataBase(++contUpdateRFuncaoAtivParada,"Recebendo Dados da Tabela RFuncaoAtivParada", qtde))
            rFuncaoAtivParadaRepository.recoverAllRFuncaoAtivParada()
                .collect{ result ->
                    result.onSuccess { rFuncaoAtivParadaList ->
                        emit(ResultUpdateDataBase(++contUpdateRFuncaoAtivParada,"Salvandos Dados da Tabela RFuncaoAtivParada", qtde))
                        rFuncaoAtivParadaRepository.addAllRFuncaoAtivParada(rFuncaoAtivParadaList)
                    }
                }
        }
    }

}