package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverNroOSBoletimMMFert {

    suspend operator fun invoke(nroOS: String, checkConn: Boolean = false): Flow<ResultUpdateDatabase>

}