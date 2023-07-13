package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_EQUIP_SEG
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipSegRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateEquipSeg
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateEquipSegImpl @Inject constructor(
    private val equipSegRepository: EquipSegRepository
): UpdateEquipSeg {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateEquipSeg = contador
            emit(ResultUpdateDatabase(++contUpdateEquipSeg,TEXT_CLEAR_TB + TB_EQUIP_SEG, qtde))
            equipSegRepository.deleteAllEquipSeg()
            emit(ResultUpdateDatabase(++contUpdateEquipSeg,TEXT_RECEIVE_WS_TB + TB_EQUIP_SEG, qtde))
            equipSegRepository.recoverAllEquipSeg()
                .collect{ result ->
                    result.onSuccess { equipSegList ->
                        emit(ResultUpdateDatabase(++contUpdateEquipSeg,TEXT_SAVE_DATA_TB + TB_EQUIP_SEG, qtde))
                        equipSegRepository.addAllEquipSeg(equipSegList)
                    }
                }
        }
    }

}