package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow

interface UpdateAllDataBase {

    suspend operator fun invoke(count: Int = 0, size: Int = 61): Flow<ResultUpdateDataBase>

}