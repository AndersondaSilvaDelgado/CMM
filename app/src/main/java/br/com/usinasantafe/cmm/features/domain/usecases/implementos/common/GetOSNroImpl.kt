package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.entities.stable.OS
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetOSNro
import javax.inject.Inject

class GetOSNroImpl @Inject constructor (
    private val osRepository: OSRepository
): GetOSNro {

    override suspend fun invoke(nroOS: Long): OS {
        return osRepository.getOSNro(nroOS)
    }

}