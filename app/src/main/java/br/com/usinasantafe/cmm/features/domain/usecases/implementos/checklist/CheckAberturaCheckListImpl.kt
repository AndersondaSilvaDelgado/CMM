package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.common.utils.dateNow
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckAberturaCheckList
import javax.inject.Inject

class CheckAberturaCheckListImpl @Inject constructor(
    private val configRepository: ConfigRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository
): CheckAberturaCheckList {

    override suspend fun invoke(): Boolean {
        return if(configRepository.getConfig().idTurno != null){
            ((boletimMMFertRepository.getIdTurnoBoletimAberto() != configRepository.getConfig().idTurno)
                    || ((boletimMMFertRepository.getIdTurnoBoletimAberto() == configRepository.getConfig().idTurno)
                    && (configRepository.getConfig().dtUltCheckList != dateNow())))
        } else false
    }

}