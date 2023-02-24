package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.common.utils.PointerStart
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.ClearDataMotoMec
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.SendDataAppUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.SentDataAppUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.StartApp
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendData
import javax.inject.Inject

class StartAppImpl @Inject constructor (
    private val startSendData: StartSendData,
    private val configRepository: ConfigRepository,
    private val sendDataAppUpdate: SendDataAppUpdate,
    private val sentDataAppUpdate: SentDataAppUpdate,
    private val clearDataMotoMec: ClearDataMotoMec,
    private val boletimMMFertRepository: BoletimMMFertRepository
): StartApp {

    override suspend fun invoke(): PointerStart {
        if(configRepository.hasConfig()){
            var result = sendDataAppUpdate()
            result.onSuccess {
                sentDataAppUpdate(it)
            }
        }
        clearDataMotoMec()
        startSendData()
        return if(boletimMMFertRepository.checkAbertoBoletimMMFert()){
            PointerStart.MENUAPONT
        } else {
            PointerStart.MENUINICIAL
        }
    }

}