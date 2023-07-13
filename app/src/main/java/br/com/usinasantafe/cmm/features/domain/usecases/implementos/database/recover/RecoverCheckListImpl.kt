package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.*
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateItemCheckList
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverCheckListImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val updateItemCheckList: UpdateItemCheckList
): RecoverCheckList {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contRecoverCheckList = contador
            var nroEquip = equipRepository.getEquip().nroEquip
            emit(ResultUpdateDatabase(++contRecoverCheckList, TEXT_CLEAR_TB + TB_EQUIP, qtde))
            equipRepository.deleteAllEquip()
            emit(ResultUpdateDatabase(++contRecoverCheckList, TEXT_RECEIVE_WS_TB + TB_EQUIP, qtde))
            equipRepository.recoverEquip(nroEquip.toString())
                .collect{ result ->
                    result.onSuccess { equipList ->
                            emit(ResultUpdateDatabase(++contRecoverCheckList, TEXT_SAVE_DATA_TB + TB_EQUIP, qtde))
                            equipRepository.addAllEquip(equipList)
                    }
                }
            updateItemCheckList(contRecoverCheckList, qtde).collect{
                emit(it)
                contRecoverCheckList = it.count;
            }
            emit(ResultUpdateDatabase(qtde, TEXT_SUCESS_UPDATE, qtde))
        }
    }

}