package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover

import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverCheckList {

    suspend operator fun invoke(contador: Int = 0, qtde: Int = 7): Flow<ResultUpdateDatabase>

}