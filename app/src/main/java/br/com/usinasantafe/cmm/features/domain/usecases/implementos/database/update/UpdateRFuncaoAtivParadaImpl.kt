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

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela RFuncaoAtivParada", size))
            rFuncaoAtivParadaRepository.deleteAllRFuncaoAtivParada()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela RFuncaoAtivParada", size))
            rFuncaoAtivParadaRepository.recoverAllRFuncaoAtivParada()
                .collect{ result ->
                    result.onSuccess { rFuncaoAtivParadaList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela RFuncaoAtivParada", size))
                        rFuncaoAtivParadaRepository.addAllRFuncaoAtivParada(rFuncaoAtivParadaList)
                    }
                }
        }
    }

}