package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_COMPONENTE
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ComponenteRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateComponente
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateComponenteImpl @Inject constructor(
    private val componenteRepository: ComponenteRepository
): UpdateComponente {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateComponente = contador
            emit(ResultUpdateDatabase(++contUpdateComponente,TEXT_CLEAR_TB + TB_COMPONENTE, qtde))
            componenteRepository.deleteAllComponente()
            emit(ResultUpdateDatabase(++contUpdateComponente,TEXT_RECEIVE_WS_TB + TB_COMPONENTE, qtde))
            componenteRepository.recoverAllComponente()
                .collect{ result ->
                    result.onSuccess { componenteList ->
                        emit(ResultUpdateDatabase(++contUpdateComponente,TEXT_SAVE_DATA_TB + TB_COMPONENTE, qtde))
                        componenteRepository.addAllComponente(componenteList)
                    }
                }
        }
    }

}