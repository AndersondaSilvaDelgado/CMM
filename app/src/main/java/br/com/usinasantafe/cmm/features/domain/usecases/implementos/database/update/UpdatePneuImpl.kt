package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_PNEU
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PneuRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdatePneu
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePneuImpl @Inject constructor(
    private val pneuRepository: PneuRepository
): UpdatePneu {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdatePneu = contador
            emit(ResultUpdateDatabase(++contUpdatePneu,TEXT_CLEAR_TB + TB_PNEU, qtde))
            pneuRepository.deleteAllPneu()
            emit(ResultUpdateDatabase(++contUpdatePneu,TEXT_RECEIVE_WS_TB + TB_PNEU, qtde))
            pneuRepository.recoverAllPneu()
                .collect{ result ->
                    result.onSuccess { pneuList ->
                        emit(ResultUpdateDatabase(++contUpdatePneu,TEXT_SAVE_DATA_TB + TB_PNEU, qtde))
                        pneuRepository.addAllPneu(pneuList)
                    }
                }
        }
    }

}