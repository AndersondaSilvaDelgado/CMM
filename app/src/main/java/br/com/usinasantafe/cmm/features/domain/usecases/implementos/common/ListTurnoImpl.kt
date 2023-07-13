package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.TurnoRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListTurno
import javax.inject.Inject

class ListTurnoImpl @Inject constructor (
    private val equipRepository: EquipRepository,
    private val turnoRepository: TurnoRepository
): ListTurno {

    override suspend fun invoke(): List<Turno> {
        return turnoRepository.listTurno(equipRepository.getEquip().codTurno)
    }

}