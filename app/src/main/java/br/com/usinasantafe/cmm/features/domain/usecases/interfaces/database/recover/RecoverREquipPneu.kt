package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover

import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverREquipPneu {

    suspend operator fun invoke(nroEquip: String, contador: Int = 0, qtde: Int = 3): Flow<ResultUpdateDatabase>

}