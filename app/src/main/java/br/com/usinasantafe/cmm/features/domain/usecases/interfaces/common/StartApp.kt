package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.common.utils.PointerStart

interface StartApp {

    suspend operator fun invoke(): PointerStart

}