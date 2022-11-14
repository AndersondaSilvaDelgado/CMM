package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.MotoMecRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateMotoMec
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateMotoMecImpl @Inject constructor(
    private val motoMecRepository: MotoMecRepository
): UpdateMotoMec {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela MotoMec", size))
            motoMecRepository.deleteAllMotoMec()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela MotoMec", size))
            motoMecRepository.getAllMotoMec()
                .collect{ result ->
                    result.onSuccess { motoMecList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela MotoMec", size))
                        motoMecRepository.addAllMotoMec(motoMecList)
                    }
                }
        }
    }

}