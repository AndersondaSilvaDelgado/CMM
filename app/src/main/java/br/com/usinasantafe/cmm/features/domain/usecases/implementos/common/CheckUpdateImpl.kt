package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.stable.TurnoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckUpdate
import javax.inject.Inject

class CheckUpdateImpl @Inject constructor (
    private val turnoRepository: TurnoRepository
): CheckUpdate {

    override suspend fun invoke(): Boolean {
        return turnoRepository.hasTurno()
    }

}