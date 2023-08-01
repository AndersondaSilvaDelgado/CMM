package br.com.usinasantafe.cmm.features.domain.usecases.workmanager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckDataSendBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SendDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.ReceiverSentDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckDataSendCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.ReceiverSentDataCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.SendDataCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SetStatusSendConfig
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.lang.Exception

@HiltWorker
class ProcessWorkManager @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val checkDataSendBoletimMMFert: CheckDataSendBoletimMMFert,
    private val checkDataSendCheckList: CheckDataSendCheckList,
    private val sendDataBoletimMMFert: SendDataBoletimMMFert,
    private val sendDataCheckList: SendDataCheckList,
    private val receiverSentDataBoletimMMFert: ReceiverSentDataBoletimMMFert,
    private val receiverSentDataCheckList: ReceiverSentDataCheckList,
    private val setStatusSendConfig: SetStatusSendConfig,
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try{
            setStatusSendConfig(StatusSend.SENDING)
            if(checkDataSendCheckList()){
                var result = sendDataCheckList()
                result.onSuccess {
                    receiverSentDataCheckList(it)
                }
            }
            if(checkDataSendBoletimMMFert()){
                var result = sendDataBoletimMMFert()
                result.onSuccess {
                    receiverSentDataBoletimMMFert(it)
                }
            }
            setStatusSendConfig(StatusSend.SENT)
            Result.success()
        } catch (e: Exception){
            setStatusSendConfig(StatusSend.SEND)
            Result.retry()
        }
    }

}