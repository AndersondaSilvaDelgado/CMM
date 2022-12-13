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

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela RAtivParada", size))
            rAtivParadaRepository.deleteAllRAtivParada()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela RAtivParada", size))
            rAtivParadaRepository.recoverAllRAtivParada()
                .collect{ result ->
                    result.onSuccess { rAtivParadaList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela RAtivParada", size))
                        rAtivParadaRepository.addAllRAtivParada(rAtivParadaList)
                    }
                }
        }
    }

}