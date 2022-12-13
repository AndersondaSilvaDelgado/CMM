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

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Componente", size))
            componenteRepository.deleteAllComponente()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Componente", size))
            componenteRepository.recoverAllComponente()
                .collect{ result ->
                    result.onSuccess { componenteList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Componente", size))
                        componenteRepository.addAllComponente(componenteList)
                    }
                }
        }
    }

}