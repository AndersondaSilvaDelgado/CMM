package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ComponenteRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateComponente
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateComponenteImpl @Inject constructor(
    private val componenteRepository: ComponenteRepository
): UpdateComponente {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateComponente = contador
            emit(ResultUpdateDataBase(++contUpdateComponente,"Limpando Dados da Tabela Componente", qtde))
            componenteRepository.deleteAllComponente()
            emit(ResultUpdateDataBase(++contUpdateComponente,"Recebendo Dados da Tabela Componente", qtde))
            componenteRepository.recoverAllComponente()
                .collect{ result ->
                    result.onSuccess { componenteList ->
                        emit(ResultUpdateDataBase(++contUpdateComponente,"Salvandos Dados da Tabela Componente", qtde))
                        componenteRepository.addAllComponente(componenteList)
                    }
                }
        }
    }

}