package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetApontTrabalhando
import javax.inject.Inject

class SetApontTrabalhandoImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository
): SetApontTrabalhando {

    override suspend fun invoke(): Boolean {
        return apontMMFertRepository.startApontMMFert(TypeNote.TRABALHANDO)
    }

}