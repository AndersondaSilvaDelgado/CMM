package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtividadeRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipAtivRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ROSAtivRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckNroOS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetOSNro
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ListAtiv
import javax.inject.Inject

class ListAtivImpl @Inject constructor (
    private val atividadeRepository: AtividadeRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val rOSAtivRepository: ROSAtivRepository,
    private val rEquipAtivRepository: REquipAtivRepository,
    private val checkNroOS: CheckNroOS,
    private val getOSNro: GetOSNro
): ListAtiv {

    override suspend fun invoke(): List<Atividade> {
        var idOS = 0L
        if(checkNroOS(boletimMMFertRepository.getOS().toString())){
            idOS = getOSNro(boletimMMFertRepository.getOS()).idOS
        }
        var listREquipAtiv = rEquipAtivRepository.listREquipAtiv(boletimMMFertRepository.getIdEquip())
        var listROSAtiv = rOSAtivRepository.listROSAtiv(idOS)

        var listIdAtiv = emptyList<Long>()

        if(listROSAtiv.isNotEmpty()){
            listREquipAtiv.forEach { rEquipAtiv ->
                listIdAtiv = listROSAtiv.filter { it.idAtiv == rEquipAtiv.idAtiv }.map { it.idAtiv }
            }
        } else {
            listIdAtiv = listREquipAtiv.map { it.idAtiv }
        }

        return atividadeRepository.listInIdAtiv(listIdAtiv)
    }

}