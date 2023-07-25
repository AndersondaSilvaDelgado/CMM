package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_ATIV
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipAtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipAtiv
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverREquipAtivImpl @Inject constructor(
    private val rEquipAtivRepository: REquipAtivRepository
): RecoverREquipAtiv {

    override suspend fun invoke(nroEquip: String, contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contRecoverREquipAtiv = contador
            emit(ResultUpdateDatabase(++contRecoverREquipAtiv,TEXT_CLEAR_TB + TB_R_EQUIP_ATIV, qtde))
            rEquipAtivRepository.deleteAllREquipAtiv()
            emit(ResultUpdateDatabase(++contRecoverREquipAtiv,TEXT_RECEIVE_WS_TB + TB_R_EQUIP_ATIV, qtde))
            rEquipAtivRepository.recoverREquipAtiv(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipAtivList ->
                        emit(ResultUpdateDatabase(++contRecoverREquipAtiv,TEXT_SAVE_DATA_TB + TB_R_EQUIP_ATIV, qtde))
                        rEquipAtivRepository.addAllREquipAtiv(rEquipAtivList)
                    }
                }
        }
    }

}