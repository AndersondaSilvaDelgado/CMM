package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover

import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverOS {

    suspend operator fun invoke(nroOS: String, contador: Int = 0, qtde: Int = 7): Flow<ResultUpdateDatabase>

}