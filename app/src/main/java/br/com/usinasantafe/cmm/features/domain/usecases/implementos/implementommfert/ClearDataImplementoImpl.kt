package br.com.usinasantafe.cmm.features.domain.usecases.implementos.implementommfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.ClearDataImplemento
import javax.inject.Inject

class ClearDataImplementoImpl @Inject constructor (
    private val implementoRepository: ImplementoRepository
): ClearDataImplemento {

    override suspend fun invoke(): Boolean {
        implementoRepository.clearData()
        return true
    }

}