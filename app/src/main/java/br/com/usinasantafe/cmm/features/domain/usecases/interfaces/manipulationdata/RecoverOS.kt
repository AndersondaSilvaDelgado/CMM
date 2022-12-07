package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow

interface RecoverOS {

    suspend operator fun invoke(nroOS: String, count: Int = 0, size: Int = 7): Flow<ResultUpdateDataBase>

}