package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.InsertParadaCheckListMMFert
import javax.inject.Inject

class InsertParadaCheckListMMFertImpl @Inject constructor(
    private val rFuncaoAtivParadaRepository: RFuncaoAtivParadaRepository,
    private val apontMMFertRepository: ApontMMFertRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository
): InsertParadaCheckListMMFert {

    override suspend fun invoke(): Boolean {
        return if(apontMMFertRepository.startApontMMFert(TypeNote.PARADA, boletimMMFertRepository.getNroOSBoletimAberto(), boletimMMFertRepository.getIdAtivBoletimAberto())){
            (apontMMFertRepository.setIdParadaApontMMFert(rFuncaoAtivParadaRepository.getParadaCheckList().idAtivPar))
        } else false
    }

}