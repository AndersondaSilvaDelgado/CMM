package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow

interface UpdateROSAtiv {

    suspend operator fun invoke(count: Int = 0, size: Int = 3): Flow<ResultUpdateDataBase>

}