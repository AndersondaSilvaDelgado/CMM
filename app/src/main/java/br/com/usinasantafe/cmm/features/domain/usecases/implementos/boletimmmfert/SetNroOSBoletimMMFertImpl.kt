package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetNroOSBoletimMMFert
import javax.inject.Inject

class SetNroOSBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): SetNroOSBoletimMMFert {

    override suspend fun invoke(nroOS: String): Boolean {
        return boletimMMFertRepository.setNroOSBoletimMMFert(nroOS)
    }

}