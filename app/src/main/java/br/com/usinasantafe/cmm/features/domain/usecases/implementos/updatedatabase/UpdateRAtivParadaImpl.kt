package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.RAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateRAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateRAtivParadaImpl @Inject constructor(
    private val rAtivParadaRepository: RAtivParadaRepository
): UpdateRAtivParada {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela RAtivParada", size))
            rAtivParadaRepository.deleteAllRAtivParada()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela RAtivParada", size))
            rAtivParadaRepository.getAllRAtivParada()
                .collect{ result ->
                    result.onSuccess { rAtivParadaList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela RAtivParada", size))
                        rAtivParadaRepository.addAllRAtivParada(rAtivParadaList)
                    }
                }
        }
    }

}