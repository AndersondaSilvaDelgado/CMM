package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListMenuECM
import javax.inject.Inject

class ListMenuECMImpl @Inject constructor(
): ListMenuECM {

    override suspend fun invoke(): List<String> {
        TODO("Not yet implemented")
    }

}