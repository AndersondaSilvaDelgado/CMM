package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.BuildConfig
import br.com.usinasantafe.cmm.common.utils.PointerStart
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckImplementoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.CheckEmptyImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendData
import javax.inject.Inject

class StartAppImpl @Inject constructor (
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val checkEmptyImplemento: CheckEmptyImplemento,
    private val checkImplementoBoletimMMFert: CheckImplementoBoletimMMFert,
    private val clearDataMotoMec: ClearDataMotoMec,
    private val configRepository: ConfigRepository,
    private val sendDataAppUpdate: SendDataAppUpdate,
    private val sentDataAppUpdate: SentDataAppUpdate,
    private val startProcessSendData: StartProcessSendData,
): StartApp {

    override suspend fun invoke(): PointerStart {
        if(configRepository.hasConfig()){
            var result = sendDataAppUpdate(BuildConfig.VERSION_NAME)
            result.onSuccess {
                sentDataAppUpdate(it)
            }
            startProcessSendData()
            clearDataMotoMec()
        }
        return if(boletimMMFertRepository.checkAbertoBoletimMMFert()){
            if(checkImplementoBoletimMMFert() && checkEmptyImplemento()){
                PointerStart.IMPLEMENTO
            } else {
                PointerStart.MENUAPONT
            }
        } else {
            PointerStart.MENUINICIAL
        }
    }

}