package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckImplementoBoletimMMFert
import javax.inject.Inject

class CheckImplementoBoletimMMFertImpl @Inject constructor(
    private val rFuncaoAtivParadaRepository: RFuncaoAtivParadaRepository
): CheckImplementoBoletimMMFert {

    override suspend fun invoke(): Boolean {
        return rFuncaoAtivParadaRepository.checkImplementoIdAtiv()
    }

}