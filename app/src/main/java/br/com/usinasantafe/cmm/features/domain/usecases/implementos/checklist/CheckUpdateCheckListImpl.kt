package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.common.utils.FlagUpdateCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckUpdateCheckList
import javax.inject.Inject

class CheckUpdateCheckListImpl @Inject constructor(
    private val configRepository: ConfigRepository
): CheckUpdateCheckList {

    override suspend fun invoke(): Boolean {
        return configRepository.getConfig().flagUpdateCheckList == FlagUpdateCheckList.DESATUALIZADO
    }

}