package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.MotoMecRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateMotoMec
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateMotoMecImpl @Inject constructor(
    private val motoMecRepository: MotoMecRepository
): UpdateMotoMec {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela MotoMec", size))
            motoMecRepository.deleteAllMotoMec()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela MotoMec", size))
            motoMecRepository.recoverAllMotoMec()
                .collect{ result ->
                    result.onSuccess { motoMecList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela MotoMec", size))
                        motoMecRepository.addAllMotoMec(motoMecList)
                    }
                }
        }
    }

}