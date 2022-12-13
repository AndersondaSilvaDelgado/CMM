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

    override suspend fun invoke(nroOS: String, count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela OS", size))
            osRepository.deleteAllOS()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela OS", size))
            osRepository.recoverOS(nroOS)
                .collect{ result ->
                    result.onSuccess { osList ->
                        if(osList.isNotEmpty()){
                            emit(ResultUpdateDataBase(++count, "Salvandos Dados da Tabela OS", size))
                            osRepository.addAllOS(osList)
                            rOSAtiv(nroOS, count, size).collect{
                                emit(it)
                                count = it.count;
                            }
                            emit(ResultUpdateDataBase(size, "Termino de Atualização", size))
                        } else {
                            emit(ResultUpdateDataBase(size, "OS Inexistente!", size))
                        }
                    }
                }
        }
    }

}