package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ComponenteRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateComponente
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateComponenteImpl @Inject constructor(
    private val componenteRepository: ComponenteRepository
): UpdateComponente {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Componente", size))
            componenteRepository.deleteAllComponente()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Componente", size))
            componenteRepository.getAllComponente()
                .collect{ result ->
                    result.onSuccess { componenteList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Componente", size))
                        componenteRepository.addAllComponente(componenteList)
                    }
                }
        }
    }

}