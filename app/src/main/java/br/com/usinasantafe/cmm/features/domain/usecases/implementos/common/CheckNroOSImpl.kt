package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import javax.inject.Inject

class CheckNroOSImpl @Inject constructor (
    private val osRepository: OSRepository
): CheckNroOS {

    override suspend fun invoke(nroOS: String): Boolean {
        return osRepository.checkOS(nroOS)
    }

}