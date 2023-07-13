package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface UpdateRAtivParada {

    suspend operator fun invoke(contador: Int = 0, qtde: Int = 3): Flow<ResultUpdateDatabase>

}