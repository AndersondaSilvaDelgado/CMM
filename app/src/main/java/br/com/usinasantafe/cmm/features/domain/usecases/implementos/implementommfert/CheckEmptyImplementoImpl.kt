package br.com.usinasantafe.cmm.features.domain.usecases.implementos.implementommfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.CheckEmptyImplemento

import javax.inject.Inject

class CheckEmptyImplementoImpl @Inject constructor (
    private val implementoRepository: ImplementoRepository
): CheckEmptyImplemento {

    override suspend fun invoke(): Boolean {
        return implementoRepository.countImplemento() == 0
    }

}