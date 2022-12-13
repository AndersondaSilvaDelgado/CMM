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

    override suspend fun invoke(nroEquip: String, count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Equip", size))
            equipRepository.deleteAllEquip()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Equip", size))
            equipRepository.recoverEquip(nroEquip)
                .collect{ result ->
                    result.onSuccess { equipList ->
                        if(equipList.isNotEmpty()){
                            emit(ResultUpdateDataBase(++count, "Salvandos Dados da Tabela Equip", size))
                            equipRepository.addAllEquip(equipList)
                            rEquipAtiv(nroEquip, count, size).collect{
                                emit(it)
                                count = it.count;
                            }
                            rEquipPneu(nroEquip, count, size).collect(){
                                emit(it)
                                count = it.count;
                            }
                            emit(ResultUpdateDataBase(size, "Termino de Atualização", size))
                        } else {
                            emit(ResultUpdateDataBase(size, "Equipamente Inexistente!", size))
                        }
                    }
                }
        }
    }

}