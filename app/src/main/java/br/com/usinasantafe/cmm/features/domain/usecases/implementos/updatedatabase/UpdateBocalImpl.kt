package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.BocalRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateBocal
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateBocalImpl @Inject constructor(
    private val bocalRepository: BocalRepository
): UpdateBocal {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Bocal", size))
            bocalRepository.deleteAllBocal()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Bocal", size))
            bocalRepository.getAllBocal()
                .collect{ result ->
                    result.onSuccess { bocalList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Bocal", size))
                        bocalRepository.addAllBocal(bocalList)
                    }
                }
        }
    }

}