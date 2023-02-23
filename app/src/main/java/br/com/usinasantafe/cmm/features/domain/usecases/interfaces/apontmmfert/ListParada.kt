package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada


interface ListParada {

    suspend operator fun invoke(): List<Parada>

}