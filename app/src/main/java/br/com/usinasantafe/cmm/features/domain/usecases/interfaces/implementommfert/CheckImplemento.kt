package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert

import br.com.usinasantafe.cmm.common.utils.StatusImplemento

interface CheckImplemento {

    suspend operator fun invoke(nroEquip: String): StatusImplemento

}