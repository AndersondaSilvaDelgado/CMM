package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.common.utils.dateNow
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckOpenCheckList
import javax.inject.Inject

class CheckOpenCheckListImpl @Inject constructor(
    private val configRepository: ConfigRepository,
    private val equipRepository: EquipRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository
): CheckOpenCheckList {

    override suspend fun invoke(): Boolean {
        return if(equipRepository.getEquip().idCheckList > 0){
            if(configRepository.getConfig().ultTurnoCheckList != null){
                if(boletimMMFertRepository.getIdTurnoBoletimAberto() != configRepository.getConfig().ultTurnoCheckList){
                    true
                } else {
                    configRepository.getConfig().dtUltCheckList != dateNow()
                }
            } else {
                true
            }
        } else {
            false
        }
    }

}