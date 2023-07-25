package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface RecoverNroOSApontMMFert {

    suspend operator fun invoke(nroOS: String): Flow<ResultUpdateDatabase>

}