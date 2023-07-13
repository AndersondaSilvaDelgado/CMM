package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverParada {

    suspend operator fun invoke(contador: Int = 0, qtde: Int = 6): Flow<ResultUpdateDatabase>

}