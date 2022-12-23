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

    override suspend fun invoke(nroEquip: String, contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contRecoverREquipPneu = contador
            emit(ResultUpdateDataBase(++contRecoverREquipPneu,"Limpando Dados da Tabela REquipPneu", qtde))
            rEquipPneuRepository.deleteAllREquipPneu()
            emit(ResultUpdateDataBase(++contRecoverREquipPneu,"Recebendo Dados da Tabela REquipPneu", qtde))
            rEquipPneuRepository.recoverREquipPneu(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipPneuList ->
                        emit(ResultUpdateDataBase(++contRecoverREquipPneu,"Salvandos Dados da Tabela REquipPneu", qtde))
                        rEquipPneuRepository.addAllREquipPneu(rEquipPneuList)
                    }
                }
        }
    }

}