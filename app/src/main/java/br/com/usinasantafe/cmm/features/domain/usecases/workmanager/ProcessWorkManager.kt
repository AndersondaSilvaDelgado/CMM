package br.com.usinasantafe.cmm.features.domain.usecases.workmanager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckSendData
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SendDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SentDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SetStatusSendConfig
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ProcessWorkManager @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val checkSendData: CheckSendData,
    private val sendDataBoletimMMFert: SendDataBoletimMMFert,
    private val sentDataBoletimMMFert: SentDataBoletimMMFert,
    private val setStatusSendConfig: SetStatusSendConfig,
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return if(checkSendData()){
            setStatusSendConfig(StatusSend.ENVIANDO)
            var result = sendDataBoletimMMFert()
            result.onSuccess {
                sentDataBoletimMMFert(it)
            }
            setStatusSendConfig(StatusSend.ENVIAR)
            return Result.retry()
        } else {
            setStatusSendConfig(StatusSend.ENVIADO)
            Result.success()
        }
    }

}