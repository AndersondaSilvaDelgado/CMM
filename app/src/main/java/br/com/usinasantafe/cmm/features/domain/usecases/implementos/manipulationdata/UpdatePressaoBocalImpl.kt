package br.com.usinasantafe.cmm.features.domain.usecases.implementos.manipulationdata

import br.com.usinasantafe.cmm.features.domain.repositories.stable.PressaoBocalRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata.UpdatePressaoBocal
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePressaoBocalImpl @Inject constructor(
    private val pressaoBocalRepository: PressaoBocalRepository
): UpdatePressaoBocal {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela PressaoBocal", size))
            pressaoBocalRepository.deleteAllPressaoBocal()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela PressaoBocal", size))
            pressaoBocalRepository.recoverAllPressaoBocal()
                .collect{ result ->
                    result.onSuccess { pressaoBocalList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela PressaoBocal", size))
                        pressaoBocalRepository.addAllPressaoBocal(pressaoBocalList)
                    }
                }
        }
    }

}