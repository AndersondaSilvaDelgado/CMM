package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverOS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverROSAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverOSImpl @Inject constructor(
    private val osRepository: OSRepository,
    private val rOSAtiv: RecoverROSAtiv
): RecoverOS {

    override suspend fun invoke(nroOS: String, contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contRecoverOS = contador
            emit(ResultUpdateDataBase(++contRecoverOS,"Limpando Dados da Tabela OS", qtde))
            osRepository.deleteAllOS()
            emit(ResultUpdateDataBase(++contRecoverOS,"Recebendo Dados da Tabela OS", qtde))
            osRepository.recoverOS(nroOS)
                .collect{ result ->
                    result.onSuccess { osList ->
                        if(osList.isNotEmpty()){
                            emit(ResultUpdateDataBase(++contRecoverOS, "Salvandos Dados da Tabela OS", qtde))
                            osRepository.addAllOS(osList)
                            rOSAtiv(nroOS, contRecoverOS, qtde).collect{
                                emit(it)
                                contRecoverOS = it.count;
                            }
                            emit(ResultUpdateDataBase(qtde, "Termino de Atualização", qtde))
                        } else {
                            emit(ResultUpdateDataBase(qtde, "OS Inexistente!", qtde))
                        }
                    }
                }
        }
    }

}