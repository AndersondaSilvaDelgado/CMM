package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.TEXT_SUCESS_UPDATE
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverParada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateParada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverParadaImpl @Inject constructor(
    private val updateRAtivParada: UpdateRAtivParada,
    private val updateParada: UpdateParada,
): RecoverParada {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            updateRAtivParada(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateParada(count, size).collect{
                emit(it)
                count = it.count;
            }
            emit(ResultUpdateDataBase(size, TEXT_SUCESS_UPDATE, size))
        }
    }

}