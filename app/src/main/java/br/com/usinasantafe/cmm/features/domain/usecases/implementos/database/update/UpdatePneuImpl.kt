package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.PneuRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdatePneu
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePneuImpl @Inject constructor(
    private val pneuRepository: PneuRepository
): UpdatePneu {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdatePneu = contador
            emit(ResultUpdateDataBase(++contUpdatePneu,"Limpando Dados da Tabela Pneu", qtde))
            pneuRepository.deleteAllPneu()
            emit(ResultUpdateDataBase(++contUpdatePneu,"Recebendo Dados da Tabela Pneu", qtde))
            pneuRepository.recoverAllPneu()
                .collect{ result ->
                    result.onSuccess { pneuList ->
                        emit(ResultUpdateDataBase(++contUpdatePneu,"Salvandos Dados da Tabela Pneu", qtde))
                        pneuRepository.addAllPneu(pneuList)
                    }
                }
        }
    }

}