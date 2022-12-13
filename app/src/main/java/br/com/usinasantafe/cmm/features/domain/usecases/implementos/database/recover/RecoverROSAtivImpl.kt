package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ROSAtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverROSAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverROSAtivImpl @Inject constructor(
    private val rOSAtivRepository: ROSAtivRepository
): RecoverROSAtiv {

    override suspend fun invoke(nroOS: String, count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela OS", size))
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