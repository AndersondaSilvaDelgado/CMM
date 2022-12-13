package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipPneuRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipPneu
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverREquipPneuImpl @Inject constructor(
    private val rEquipPneuRepository: REquipPneuRepository
): RecoverREquipPneu {

    override suspend fun invoke(nroEquip: String, count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela REquipPneu", size))
            rEquipPneuRepository.deleteAllREquipPneu()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela REquipPneu", size))
            rEquipPneuRepository.recoverREquipPneu(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipPneuList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela REquipPneu", size))
                        rEquipPneuRepository.addAllREquipPneu(rEquipPneuList)
                    }
                }
        }
    }

}