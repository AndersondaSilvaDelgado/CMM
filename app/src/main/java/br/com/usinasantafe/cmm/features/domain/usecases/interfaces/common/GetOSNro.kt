package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.stable.OS

interface GetOSNro {

    suspend operator fun invoke(nroOS: Long): OS

}