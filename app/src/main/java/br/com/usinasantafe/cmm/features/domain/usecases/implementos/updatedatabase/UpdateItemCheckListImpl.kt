package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateItemCheckList
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateItemCheckListImpl @Inject constructor(
    private val itemCheckListRepository: ItemCheckListRepository
): UpdateItemCheckList {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela ItemCheckList", size))
            itemCheckListRepository.deleteAllItemCheckList()
                    emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela ItemCheckList", size))
            itemCheckListRepository.getAllItemCheckList()
                .collect{ result ->
                    result.onSuccess { itemCheckListList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela ItemCheckList", size))
                        itemCheckListRepository.addAllItemCheckList(itemCheckListList)
                    }
                }
        }
    }

}