package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.BocalRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateBocal
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateBocalImpl @Inject constructor(
    private val bocalRepository: BocalRepository
): UpdateBocal {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateBocal = contador
            emit(ResultUpdateDataBase(++contUpdateBocal,"Limpando Dados da Tabela Bocal", qtde))
            bocalRepository.deleteAllBocal()
            emit(ResultUpdateDataBase(++contUpdateBocal,"Recebendo Dados da Tabela Bocal", qtde))
            bocalRepository.recoverAllBocal()
                .collect{ result ->
                    result.onSuccess { bocalList ->
                        emit(ResultUpdateDataBase(++contUpdateBocal,"Salvandos Dados da Tabela Bocal", qtde))
                        bocalRepository.addAllBocal(bocalList)
                    }
                }
        }
    }

}