package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_ITEM_CHECKLIST
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemOSMecanRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateItemOSMecan
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateItemOSMecanImpl @Inject constructor(
    private val itemOSMecanRepository: ItemOSMecanRepository
): UpdateItemOSMecan {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateItemOSMecan = contador
            emit(ResultUpdateDatabase(++contUpdateItemOSMecan, TEXT_CLEAR_TB + TB_ITEM_CHECKLIST, qtde))
            itemOSMecanRepository.deleteAllItemOSMecan()
            emit(ResultUpdateDatabase(++contUpdateItemOSMecan,TEXT_RECEIVE_WS_TB + TB_ITEM_CHECKLIST, qtde))
            itemOSMecanRepository.recoverAllItemOSMecan()
                .collect{ result ->
                    result.onSuccess { itemOSMecanList ->
                        emit(ResultUpdateDatabase(++contUpdateItemOSMecan,TEXT_SAVE_DATA_TB + TB_ITEM_CHECKLIST, qtde))
                        itemOSMecanRepository.addAllItemOSMecan(itemOSMecanList)
                    }
                }
        }
    }

}