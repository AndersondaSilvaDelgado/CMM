package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetApontParada
import javax.inject.Inject

class SetApontParadaImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository
): SetApontParada {

    override suspend fun invoke(): Boolean {
        return apontMMFertRepository.startApontMMFert(TypeNote.PARADA)
    }

}