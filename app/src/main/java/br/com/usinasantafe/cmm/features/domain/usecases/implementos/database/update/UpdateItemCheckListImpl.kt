package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

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
            emit(ResultUpdateDataBase(++contUpdateItemCheckList, "Limpando Dados da Tabela ItemCheckList", qtde))
            itemCheckListRepository.deleteAllItemCheckList()
                    emit(ResultUpdateDataBase(++contUpdateItemCheckList,"Recebendo Dados da Tabela ItemCheckList", qtde))
            itemCheckListRepository.recoverAllItemCheckList()
                .collect{ result ->
                    result.onSuccess { itemCheckListList ->
                        emit(ResultUpdateDataBase(++contUpdateItemCheckList,"Salvandos Dados da Tabela ItemCheckList", qtde))
                        itemCheckListRepository.addAllItemCheckList(itemCheckListList)
                    }
                }
        }
    }

}