package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow

interface RecoverParada {

    suspend operator fun invoke(count: Int = 0, size: Int = 6): Flow<ResultUpdateDataBase>

}