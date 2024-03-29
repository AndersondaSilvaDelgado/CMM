package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_PROPRIEDADE
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PropriedadeRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdatePropriedade
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePropriedadeImpl @Inject constructor(
    private val propriedadeRepository: PropriedadeRepository
): UpdatePropriedade {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdatePropriedade = contador
            emit(ResultUpdateDatabase(++contUpdatePropriedade,TEXT_CLEAR_TB + TB_PROPRIEDADE, qtde))
            propriedadeRepository.deleteAllPropriedade()
            emit(ResultUpdateDatabase(++contUpdatePropriedade,TEXT_RECEIVE_WS_TB + TB_PROPRIEDADE, qtde))
            propriedadeRepository.recoverAllPropriedade()
                .collect{ result ->
                    result.onSuccess { propriedadeList ->
                        emit(ResultUpdateDatabase(++contUpdatePropriedade,TEXT_SAVE_DATA_TB + TB_PROPRIEDADE, qtde))
                        propriedadeRepository.addAllPropriedade(propriedadeList)
                    }
                }
        }
    }

}