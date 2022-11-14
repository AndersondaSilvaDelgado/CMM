package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipSegRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateEquipSeg
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateEquipSegImpl @Inject constructor(
    private val equipSegRepository: EquipSegRepository
): UpdateEquipSeg {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela EquipSeg", size))
            equipSegRepository.deleteAllEquipSeg()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela EquipSeg", size))
            equipSegRepository.getAllEquipSeg()
                .collect{ result ->
                    result.onSuccess { equipSegList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela EquipSeg", size))
                        equipSegRepository.addAllEquipSeg(equipSegList)
                    }
                }
        }
    }

}