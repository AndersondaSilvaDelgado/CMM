package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdAtivBoletimMMFert
import javax.inject.Inject

class SetIdAtivBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): SetIdAtivBoletimMMFert {

    override suspend fun invoke(idAtiv: Long): Boolean {
        return boletimMMFertRepository.setIdAtivBoletimMMFert(idAtiv)
    }

}