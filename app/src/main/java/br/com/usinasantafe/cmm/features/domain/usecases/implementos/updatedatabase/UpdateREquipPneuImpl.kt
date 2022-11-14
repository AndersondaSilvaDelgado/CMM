package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipPneuRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateREquipPneu
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateREquipPneuImpl @Inject constructor(
    private val rEquipPneuRepository: REquipPneuRepository
): UpdateREquipPneu {

    override suspend fun invoke(nroEquip: String, count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela REquipPneu", size))
            rEquipPneuRepository.deleteAllREquipPneu()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela REquipPneu", size))
            rEquipPneuRepository.getREquipPneu(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipPneuList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela REquipPneu", size))
                        rEquipPneuRepository.addAllREquipPneu(rEquipPneuList)
                    }
                }
        }
    }

}