package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListMenuPCOMP
import javax.inject.Inject

class ListMenuPCOMPImpl @Inject constructor(
): ListMenuPCOMP {

    override suspend fun invoke(): List<String> {
        TODO("Not yet implemented")
    }

}