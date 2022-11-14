package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.PressaoBocalRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdatePressaoBocal
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePressaoBocalImpl @Inject constructor(
    private val pressaoBocalRepository: PressaoBocalRepository
): UpdatePressaoBocal {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela PressaoBocal", size))
            pressaoBocalRepository.deleteAllPressaoBocal()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela PressaoBocal", size))
            pressaoBocalRepository.getAllPressaoBocal()
                .collect{ result ->
                    result.onSuccess { pressaoBocalList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela PressaoBocal", size))
                        pressaoBocalRepository.addAllPressaoBocal(pressaoBocalList)
                    }
                }
        }
    }

}