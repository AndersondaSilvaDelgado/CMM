package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.common.extension.percentage
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateEquip
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateREquipAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateREquipPneu
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateEquipImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val rEquipAtiv: UpdateREquipAtiv,
    private val rEquipPneu: UpdateREquipPneu,
): UpdateEquip {

    override suspend fun invoke(nroEquip: String, count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var count = count
            val size = 10
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Equip", size))
            equipRepository.deleteAllEquip()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Equip", size))
            equipRepository.getEquip(nroEquip)
                .collect{ result ->
                    result.onSuccess { equipList ->
                        if(equipList.isNotEmpty()){
                            emit(ResultUpdateDataBase(++count, "Salvandos Dados da Tabela Equip", size))
                            equipRepository.addAllEquip(equipList)
                            rEquipAtiv(nroEquip, count).collect{
                                it.size = size
                                emit(it)
                                count = it.count;
                            }
                            rEquipPneu(nroEquip, count).collect(){
                                it.size = size
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