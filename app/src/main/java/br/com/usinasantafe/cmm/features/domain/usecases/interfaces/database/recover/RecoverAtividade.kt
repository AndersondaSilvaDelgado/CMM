package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover

import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverAtividade {

    suspend operator fun invoke(flowNote: FlowNote, contador: Int = 0, qtde: Int = 13): Flow<ResultUpdateDatabase>

}