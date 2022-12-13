package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ROSAtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateROSAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateROSAtivImpl @Inject constructor(
    private val rOSAtivRepository: ROSAtivRepository
): UpdateROSAtiv {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela ROSAtiv", size))
            rOSAtivRepository.deleteAllROSAtiv()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela ROSAtiv", size))
            rOSAtivRepository.recoverAllROSAtiv()
                .collect{ result ->
                    result.onSuccess { rOSAtivList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela ROSAtiv", size))
                        rOSAtivRepository.addAllROSAtiv(rOSAtivList)
                    }
                }
        }
    }

}