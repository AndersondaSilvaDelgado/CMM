package br.com.usinasantafe.cmm.features.domain.usecases.implementos.implementommfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.AddImplemento
import javax.inject.Inject

class AddImplementoImpl @Inject constructor(
    private val implementoRepository: ImplementoRepository
): AddImplemento {

    override suspend fun invoke(nroEquip: String): Boolean {
        return implementoRepository.addImplemento(nroEquip.toLong())
    }

}