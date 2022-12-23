package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemOSMecanRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateItemOSMecan
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateItemOSMecanImpl @Inject constructor(
    private val itemOSMecanRepository: ItemOSMecanRepository
): UpdateItemOSMecan {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateItemOSMecan = contador
            emit(ResultUpdateDataBase(++contUpdateItemOSMecan, "Limpando Dados da Tabela ItemOSMecan", qtde))
            itemOSMecanRepository.deleteAllItemOSMecan()
            emit(ResultUpdateDataBase(++contUpdateItemOSMecan,"Recebendo Dados da Tabela ItemOSMecan", qtde))
            itemOSMecanRepository.recoverAllItemOSMecan()
                .collect{ result ->
                    result.onSuccess { itemOSMecanList ->
                        emit(ResultUpdateDataBase(++contUpdateItemOSMecan,"Salvandos Dados da Tabela ItemCheckList", qtde))
                        itemOSMecanRepository.addAllItemOSMecan(itemOSMecanList)
                    }
                }
        }
    }

}