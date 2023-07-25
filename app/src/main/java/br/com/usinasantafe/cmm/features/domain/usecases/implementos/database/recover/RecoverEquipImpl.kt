package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.*
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverEquip
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipPneu
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverEquipImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val rEquipAtiv: RecoverREquipAtiv,
    private val rEquipPneu: RecoverREquipPneu,
): RecoverEquip {

    override suspend fun invoke(nroEquip: String, contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contRecoverEquip = contador
            emit(ResultUpdateDatabase(++contRecoverEquip, TEXT_CLEAR_TB + TB_EQUIP, qtde))
            equipRepository.deleteAllEquip()
            emit(ResultUpdateDatabase(++contRecoverEquip,TEXT_RECEIVE_WS_TB + TB_EQUIP, qtde))
            equipRepository.recoverEquip(nroEquip)
                .collect{ result ->
                    result.onSuccess { equipList ->
                        if(equipList.isNotEmpty()){
                            emit(ResultUpdateDatabase(++contRecoverEquip, TEXT_SAVE_DATA_TB + TB_EQUIP, qtde))
                            equipRepository.addAllEquip(equipList)
                            rEquipAtiv(nroEquip, contRecoverEquip, qtde).collect{
                                emit(it)
                                contRecoverEquip = it.count;
                            }
                            rEquipPneu(nroEquip, contRecoverEquip, qtde).collect(){
                                emit(it)
                                contRecoverEquip = it.count;
                            }
                            emit(ResultUpdateDatabase(qtde, TEXT_FINISH_UPDATE, qtde))
                        } else {
                            emit(ResultUpdateDatabase(qtde, WEB_RETURN_CLEAR_EQUIP, qtde))
                        }
                    }
                }
        }
    }

}