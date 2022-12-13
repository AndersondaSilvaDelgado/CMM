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

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Pneu", size))
            pneuRepository.deleteAllPneu()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Pneu", size))
            pneuRepository.recoverAllPneu()
                .collect{ result ->
                    result.onSuccess { pneuList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Pneu", size))
                        pneuRepository.addAllPneu(pneuList)
                    }
                }
        }
    }

}