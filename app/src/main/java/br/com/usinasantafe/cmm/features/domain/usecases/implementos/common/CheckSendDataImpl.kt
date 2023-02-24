package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckSendBoletimMM
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckSendData
import javax.inject.Inject

class CheckSendDataImpl @Inject constructor(
    private val checkSendBoletimMM: CheckSendBoletimMM
) : CheckSendData {

    override suspend fun invoke(): Boolean {
        return checkSendBoletimMM()
    }

}