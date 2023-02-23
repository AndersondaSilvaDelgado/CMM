package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtivRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipAtivRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ROSAtivRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetOSNro
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListAtiv
import javax.inject.Inject

class ListAtivImpl @Inject constructor (
    private val equipRepository: EquipRepository,
    private val ativRepository: AtivRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val apontMMFertRepository: ApontMMFertRepository,
    private val rOSAtivRepository: ROSAtivRepository,
    private val rEquipAtivRepository: REquipAtivRepository,
    private val checkNroOS: CheckNroOS,
    private val getOSNro: GetOSNro
): ListAtiv {

    override suspend fun invoke(flowNote: FlowNote): List<Ativ> {

        var idOS = 0L
        var nroOS = if(flowNote == FlowNote.BOLETIM) boletimMMFertRepository.getOS() else apontMMFertRepository.getNroOS()

        if(checkNroOS(nroOS.toString())){
            idOS = getOSNro(nroOS).idOS
        }
        var listREquipAtiv = rEquipAtivRepository.listREquipAtiv(equipRepository.getEquip().idEquip)
        var listROSAtiv = rOSAtivRepository.listROSAtiv(idOS)

        var listIdAtiv = emptyList<Long>()

        if(listROSAtiv.isNotEmpty()){
            listREquipAtiv.forEach { rEquipAtiv ->
                listIdAtiv = listROSAtiv.filter { it.idAtiv == rEquipAtiv.idAtiv }.map { it.idAtiv }
            }
        } else {
            listIdAtiv = listREquipAtiv.map { it.idAtiv }
        }

        return ativRepository.listInIdAtiv(listIdAtiv)
    }

}