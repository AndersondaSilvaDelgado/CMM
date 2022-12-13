package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetNroOSApontMMFert
import javax.inject.Inject

class SetNroOSApontMMFertImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository
): SetNroOSApontMMFert {

    override suspend fun invoke(nroOS: String): Boolean {
        TODO("Not yet implemented")
    }

}