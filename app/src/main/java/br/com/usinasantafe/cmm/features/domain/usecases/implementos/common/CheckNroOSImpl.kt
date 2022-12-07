package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.stable.FuncRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckNroOSImpl @Inject constructor (
    private val osRepository: OSRepository
): CheckNroOS {

    override suspend fun invoke(nroOS: String): Boolean {
        return osRepository.checkOS(nroOS)
    }

}