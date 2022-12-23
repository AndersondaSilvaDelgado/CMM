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

    override suspend fun invoke(nroOS: String, contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contRecoverROSAtiv = contador
            emit(ResultUpdateDataBase(++contRecoverROSAtiv,"Limpando Dados da Tabela OS", qtde))
            rOSAtivRepository.deleteAllROSAtiv()
            emit(ResultUpdateDataBase(++contRecoverROSAtiv,"Recebendo Dados da Tabela ROSAtiv", qtde))
            rOSAtivRepository.recoverAllROSAtiv()
                .collect{ result ->
                    result.onSuccess { rOSAtivList ->
                        emit(ResultUpdateDataBase(++contRecoverROSAtiv,"Salvandos Dados da Tabela ROSAtiv", qtde))
                        rOSAtivRepository.addAllROSAtiv(rOSAtivList)
                    }
                }
        }
    }

}