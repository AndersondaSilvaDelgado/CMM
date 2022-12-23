package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverEquip
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipPneu
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverEquipImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val rEquipAtiv: RecoverREquipAtiv,
    private val rEquipPneu: RecoverREquipPneu,
): RecoverEquip {

    override suspend fun invoke(nroEquip: String, contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contRecoverEquip = contador
            emit(ResultUpdateDataBase(++contRecoverEquip,"Limpando Dados da Tabela Equip", qtde))
            equipRepository.deleteAllEquip()
            emit(ResultUpdateDataBase(++contRecoverEquip,"Recebendo Dados da Tabela Equip", qtde))
            equipRepository.recoverEquip(nroEquip)
                .collect{ result ->
                    result.onSuccess { equipList ->
                        if(equipList.isNotEmpty()){
                            emit(ResultUpdateDataBase(++contRecoverEquip, "Salvandos Dados da Tabela Equip", qtde))
                            equipRepository.addAllEquip(equipList)
                            rEquipAtiv(nroEquip, contRecoverEquip, qtde).collect{
                                emit(it)
                                contRecoverEquip = it.count;
                            }
                            rEquipPneu(nroEquip, contRecoverEquip, qtde).collect(){
                                emit(it)
                                contRecoverEquip = it.count;
                            }
                            emit(ResultUpdateDataBase(qtde, "Termino de Atualização", qtde))
                        } else {
                            emit(ResultUpdateDataBase(qtde, "Equipamente Inexistente!", qtde))
                        }
                    }
                }
        }
    }

}