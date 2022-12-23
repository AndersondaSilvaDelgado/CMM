package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipSegRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateEquipSeg
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateEquipSegImpl @Inject constructor(
    private val equipSegRepository: EquipSegRepository
): UpdateEquipSeg {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateEquipSeg = contador
            emit(ResultUpdateDataBase(++contUpdateEquipSeg,"Limpando Dados da Tabela EquipSeg", qtde))
            equipSegRepository.deleteAllEquipSeg()
            emit(ResultUpdateDataBase(++contUpdateEquipSeg,"Recebendo Dados da Tabela EquipSeg", qtde))
            equipSegRepository.recoverAllEquipSeg()
                .collect{ result ->
                    result.onSuccess { equipSegList ->
                        emit(ResultUpdateDataBase(++contUpdateEquipSeg,"Salvandos Dados da Tabela EquipSeg", qtde))
                        equipSegRepository.addAllEquipSeg(equipSegList)
                    }
                }
        }
    }

}