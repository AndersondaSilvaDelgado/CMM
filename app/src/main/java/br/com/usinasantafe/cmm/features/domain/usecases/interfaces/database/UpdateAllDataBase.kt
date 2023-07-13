package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface UpdateAllDataBase {

    suspend operator fun invoke(count: Int = 0, size: Int = 64): Flow<ResultUpdateDatabase>

}