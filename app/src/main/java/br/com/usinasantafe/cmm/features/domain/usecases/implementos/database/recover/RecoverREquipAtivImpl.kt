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

    override suspend fun invoke(nroEquip: String, count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela REquipAtiv", size))
            rEquipAtivRepository.deleteAllREquipAtiv()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela REquipAtiv", size))
            rEquipAtivRepository.recoverREquipAtiv(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipAtivList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela REquipAtiv", size))
                        rEquipAtivRepository.addAllREquipAtiv(rEquipAtivList)
                    }
                }
        }
    }

}