package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipAtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateREquipAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateREquipAtivImpl @Inject constructor(
    private val rEquipAtivRepository: REquipAtivRepository
): UpdateREquipAtiv {

    override suspend fun invoke(nroEquip: String, count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela REquipAtiv", size))
            rEquipAtivRepository.deleteAllREquipAtiv()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela REquipAtiv", size))
            rEquipAtivRepository.getREquipAtiv(nroEquip)
                .collect{ result ->
                    result.onSuccess { rEquipAtivList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela REquipAtiv", size))
                        rEquipAtivRepository.addAllREquipAtiv(rEquipAtivList)
                    }
                }
        }
    }

}