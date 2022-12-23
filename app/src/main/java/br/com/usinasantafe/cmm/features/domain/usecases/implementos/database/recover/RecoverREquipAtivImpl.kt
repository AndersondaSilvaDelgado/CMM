package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipAtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverREquipAtivImpl @Inject constructor(
    private val rEquipAtivRepository: REquipAtivRepository
): RecoverREquipAtiv {

    override suspend fun invoke(nroEquip: String, contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contRecoverREquipAtiv = contador
            emit(ResultUpdateDataBase(++contRecoverREquipAtiv,"Limpando Dados da Tabela REquipAtiv", qtde))
            rEquipAtivRepository.deleteAllREquipAtiv()
            emit(ResultUpdateDataBase(++contRecoverREquipAtiv,"Recebendo Dados da Tabela REquipAtiv", qtde))
            rEquipAtivRepository.recoverREquipAtiv(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipAtivList ->
                        emit(ResultUpdateDataBase(++contRecoverREquipAtiv,"Salvandos Dados da Tabela REquipAtiv", qtde))
                        rEquipAtivRepository.addAllREquipAtiv(rEquipAtivList)
                    }
                }
        }
    }

}