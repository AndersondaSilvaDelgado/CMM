package br.com.usinasantafe.cmm.features.domain.usecases.implementos.manipulationdata

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata.UpdateParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateParadaImpl @Inject constructor(
    private val paradaRepository: ParadaRepository
): UpdateParada {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Parada", size))
            paradaRepository.deleteAllParada()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Parada", size))
            paradaRepository.recoverAllParada()
                .collect{ result ->
                    result.onSuccess { paradaList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Parada", size))
                        paradaRepository.addAllParada(paradaList)
                    }
                }
        }
    }

}