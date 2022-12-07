package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetIdTurnoBoletimMMFert
import javax.inject.Inject

class SetIdTurnoBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): SetIdTurnoBoletimMMFert {

    override suspend fun invoke(idTurno: Long): Boolean {
        return boletimMMFertRepository.setIdTurnoBoletimMMFert(idTurno)
    }

}