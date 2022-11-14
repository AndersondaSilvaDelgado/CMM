package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import android.util.Log
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtividadeRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateAtividade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateAtividadeImpl @Inject constructor(
    private val atividadeRepository: AtividadeRepository
): UpdateAtividade {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela Atividade", size))
            atividadeRepository.deleteAllAtividade()
            emit(ResultUpdateDataBase(++count, "Recebendo Dados da Tabela Atividade", size))
            atividadeRepository.getAllAtividade()
                .collect{ result ->
                    result.onSuccess { ativList ->
                        emit(ResultUpdateDataBase(++count, "Salvandos Dados da Tabela Atividade", size))
                        atividadeRepository.addAllAtividade(ativList)
                    }
                }
        }
    }

}