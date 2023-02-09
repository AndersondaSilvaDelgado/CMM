package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_ITEM_CHECKLIST
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateItemCheckList
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateItemCheckListImpl @Inject constructor(
    private val itemCheckListRepository: ItemCheckListRepository
): UpdateItemCheckList {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateItemCheckList = contador
            emit(ResultUpdateDataBase(++contUpdateItemCheckList, TEXT_CLEAR_TB + TB_ITEM_CHECKLIST, qtde))
            itemCheckListRepository.deleteAllItemCheckList()
                    emit(ResultUpdateDataBase(++contUpdateItemCheckList,TEXT_RECEIVE_WS_TB + TB_ITEM_CHECKLIST, qtde))
            itemCheckListRepository.recoverAllItemCheckList()
                .collect{ result ->
                    result.onSuccess { itemCheckListList ->
                        emit(ResultUpdateDataBase(++contUpdateItemCheckList,TEXT_SAVE_DATA_TB + TB_ITEM_CHECKLIST, qtde))
                        itemCheckListRepository.addAllItemCheckList(itemCheckListList)
                    }
                }
        }
    }

}