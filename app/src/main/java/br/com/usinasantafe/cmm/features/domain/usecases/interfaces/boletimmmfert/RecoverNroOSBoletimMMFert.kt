package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverNroOSBoletimMMFert {

    suspend operator fun invoke(nroOS: String): Flow<ResultUpdateDatabase>

}