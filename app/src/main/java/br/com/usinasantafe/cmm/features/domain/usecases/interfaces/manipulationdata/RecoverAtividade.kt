package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.manipulationdata

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow

interface RecoverAtividade {

    suspend operator fun invoke(count: Int = 0, size: Int = 13): Flow<ResultUpdateDataBase>

}