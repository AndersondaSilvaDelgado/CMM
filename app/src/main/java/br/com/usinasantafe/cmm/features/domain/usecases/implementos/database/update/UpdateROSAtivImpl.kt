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

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateROSAtiv = contador
            emit(ResultUpdateDataBase(++contUpdateROSAtiv,"Limpando Dados da Tabela ROSAtiv", qtde))
            rOSAtivRepository.deleteAllROSAtiv()
            emit(ResultUpdateDataBase(++contUpdateROSAtiv,"Recebendo Dados da Tabela ROSAtiv", qtde))
            rOSAtivRepository.recoverAllROSAtiv()
                .collect{ result ->
                    result.onSuccess { rOSAtivList ->
                        emit(ResultUpdateDataBase(++contUpdateROSAtiv,"Salvandos Dados da Tabela ROSAtiv", qtde))
                        rOSAtivRepository.addAllROSAtiv(rOSAtivList)
                    }
                }
        }
    }

}