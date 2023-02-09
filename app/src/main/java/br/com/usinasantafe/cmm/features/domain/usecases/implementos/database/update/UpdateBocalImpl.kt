package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_BOCAL
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.BocalRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateBocal
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateBocalImpl @Inject constructor(
    private val bocalRepository: BocalRepository
): UpdateBocal {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateBocal = contador
            emit(ResultUpdateDataBase(++contUpdateBocal,TEXT_CLEAR_TB + TB_BOCAL, qtde))
            bocalRepository.deleteAllBocal()
            emit(ResultUpdateDataBase(++contUpdateBocal, TEXT_RECEIVE_WS_TB + TB_BOCAL, qtde))
            bocalRepository.recoverAllBocal()
                .collect{ result ->
                    result.onSuccess { bocalList ->
                        emit(ResultUpdateDataBase(++contUpdateBocal,TEXT_SAVE_DATA_TB + TB_BOCAL, qtde))
                        bocalRepository.addAllBocal(bocalList)
                    }
                }
        }
    }

}