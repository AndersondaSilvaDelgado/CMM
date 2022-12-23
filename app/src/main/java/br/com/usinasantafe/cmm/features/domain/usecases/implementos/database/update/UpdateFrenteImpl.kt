package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.FrenteRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateFrente
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateFrenteImpl @Inject constructor(
    private val frenteRepository: FrenteRepository
): UpdateFrente {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateFrente = contador
            emit(ResultUpdateDataBase(++contUpdateFrente, "Limpando Dados da Tabela Frente", qtde))
            frenteRepository.deleteAllFrente()
            emit(ResultUpdateDataBase(++contUpdateFrente,"Recebendo Dados da Tabela Frente", qtde))
            frenteRepository.recoverAllFrente()
                .collect{ result ->
                    result.onSuccess { frenteList ->
                        emit(ResultUpdateDataBase(++contUpdateFrente,"Salvandos Dados da Tabela Frente", qtde))
                        frenteRepository.addAllFrente(frenteList)
                    }
                }
        }
    }

}