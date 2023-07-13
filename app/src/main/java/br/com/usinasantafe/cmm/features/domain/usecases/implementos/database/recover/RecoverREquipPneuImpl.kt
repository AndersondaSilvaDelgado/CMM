package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_PNEU
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipPneuRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipPneu
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverREquipPneuImpl @Inject constructor(
    private val rEquipPneuRepository: REquipPneuRepository
): RecoverREquipPneu {

    override suspend fun invoke(nroEquip: String, contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contRecoverREquipPneu = contador
            emit(ResultUpdateDatabase(++contRecoverREquipPneu,TEXT_CLEAR_TB + TB_R_EQUIP_PNEU, qtde))
            rEquipPneuRepository.deleteAllREquipPneu()
            emit(ResultUpdateDatabase(++contRecoverREquipPneu,TEXT_RECEIVE_WS_TB + TB_R_EQUIP_PNEU, qtde))
            rEquipPneuRepository.recoverREquipPneu(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipPneuList ->
                        emit(ResultUpdateDatabase(++contRecoverREquipPneu,TEXT_SAVE_DATA_TB + TB_R_EQUIP_PNEU, qtde))
                        rEquipPneuRepository.addAllREquipPneu(rEquipPneuList)
                    }
                }
        }
    }

}