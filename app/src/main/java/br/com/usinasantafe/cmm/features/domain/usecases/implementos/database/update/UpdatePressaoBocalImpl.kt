package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.PressaoBocalRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdatePressaoBocal
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePressaoBocalImpl @Inject constructor(
    private val pressaoBocalRepository: PressaoBocalRepository
): UpdatePressaoBocal {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdatePressaoBocal = contador
            emit(ResultUpdateDataBase(++contUpdatePressaoBocal,"Limpando Dados da Tabela PressaoBocal", qtde))
            pressaoBocalRepository.deleteAllPressaoBocal()
            emit(ResultUpdateDataBase(++contUpdatePressaoBocal,"Recebendo Dados da Tabela PressaoBocal", qtde))
            pressaoBocalRepository.recoverAllPressaoBocal()
                .collect{ result ->
                    result.onSuccess { pressaoBocalList ->
                        emit(ResultUpdateDataBase(++contUpdatePressaoBocal,"Salvandos Dados da Tabela PressaoBocal", qtde))
                        pressaoBocalRepository.addAllPressaoBocal(pressaoBocalList)
                    }
                }
        }
    }

}