package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.PositionImplemento
import javax.inject.Inject

class PositionImplementoImpl @Inject constructor (
    private val implementoRepository: ImplementoRepository
): PositionImplemento {

    override suspend fun invoke(): Int {
        return implementoRepository.countImplemento() + 1
    }

}