package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ClearDataMotoMec
import javax.inject.Inject

class ClearDataMotoMecImpl @Inject constructor (
    private val boletimmMMFertRepository: BoletimMMFertRepository
): ClearDataMotoMec {

    override suspend fun invoke() {
        boletimmMMFertRepository.deleteBoletimEnviado()
    }

}