package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.common.utils.FlagUpdateCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckAtualCheckList
import javax.inject.Inject

class CheckAtualCheckListImpl @Inject constructor(
    private val configRepository: ConfigRepository
): CheckAtualCheckList {

    override suspend fun invoke(): Boolean {
        return configRepository.getConfig().flagUpdateCheckList == FlagUpdateCheckList.DESATUALIZADO
    }

}