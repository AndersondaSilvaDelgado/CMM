package br.com.usinasantafe.cmm.features.domain.usecases.implementos.manipulationdata

import br.com.usinasantafe.cmm.features.domain.repositories.stable.FrenteRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata.UpdateFrente
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateFrenteImpl @Inject constructor(
    private val frenteRepository: FrenteRepository
): UpdateFrente {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela Frente", size))
            frenteRepository.deleteAllFrente()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Frente", size))
            frenteRepository.recoverAllFrente()
                .collect{ result ->
                    result.onSuccess { frenteList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Frente", size))
                        frenteRepository.addAllFrente(frenteList)
                    }
                }
        }
    }

}