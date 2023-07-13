package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.TEXT_SUCESS_UPDATE
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverParada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateParada
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverParadaImpl @Inject constructor(
    private val updateRAtivParada: UpdateRAtivParada,
    private val updateParada: UpdateParada,
): RecoverParada {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contRecoverParada = contador
            updateRAtivParada(contRecoverParada, qtde).collect{
                emit(it)
                contRecoverParada = it.count;
            }
            updateParada(contRecoverParada, qtde).collect{
                emit(it)
                contRecoverParada = it.count;
            }
            emit(ResultUpdateDatabase(qtde, TEXT_SUCESS_UPDATE, qtde))
        }
    }

}