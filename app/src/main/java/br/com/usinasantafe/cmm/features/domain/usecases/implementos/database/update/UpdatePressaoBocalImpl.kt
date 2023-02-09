package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_PRESSAO_BOCAL
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PressaoBocalRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdatePressaoBocal
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePressaoBocalImpl @Inject constructor(
    private val pressaoBocalRepository: PressaoBocalRepository
): UpdatePressaoBocal {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdatePressaoBocal = contador
            emit(ResultUpdateDataBase(++contUpdatePressaoBocal,TEXT_CLEAR_TB + TB_PRESSAO_BOCAL, qtde))
            pressaoBocalRepository.deleteAllPressaoBocal()
            emit(ResultUpdateDataBase(++contUpdatePressaoBocal,TEXT_RECEIVE_WS_TB + TB_PRESSAO_BOCAL, qtde))
            pressaoBocalRepository.recoverAllPressaoBocal()
                .collect{ result ->
                    result.onSuccess { pressaoBocalList ->
                        emit(ResultUpdateDataBase(++contUpdatePressaoBocal,TEXT_SAVE_DATA_TB + TB_PRESSAO_BOCAL, qtde))
                        pressaoBocalRepository.addAllPressaoBocal(pressaoBocalList)
                    }
                }
        }
    }

}