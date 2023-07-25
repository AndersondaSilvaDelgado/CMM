package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.AddImplementoBoletimMMFert
import javax.inject.Inject

class AddImplementoBoletimMMFertImpl @Inject constructor(
    private val implementoRepository: ImplementoRepository
): AddImplementoBoletimMMFert {

    override suspend fun invoke(nroEquip: String): Boolean {
        return implementoRepository.addImplemento(nroEquip.toLong())
    }

}