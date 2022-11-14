package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow

interface UpdateMotoMec {

    suspend operator fun invoke(count: Int = 0): Flow<ResultUpdateDataBase>

}