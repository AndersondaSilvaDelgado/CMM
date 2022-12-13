package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno

interface ListTurno {

    suspend operator fun invoke(): List<Turno>

}