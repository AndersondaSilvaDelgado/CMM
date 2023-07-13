package br.com.usinasantafe.cmm.features.domain.usecases.workmanager

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SendDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SentDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckStatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SetStatusSendConfig
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.lang.Exception

@HiltWorker
class ProcessWorkManager @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val checkStatusSend: CheckStatusSend,
    private val sendDataBoletimMMFert: SendDataBoletimMMFert,
    private val sentDataBoletimMMFert: SentDataBoletimMMFert,
    private val setStatusSendConfig: SetStatusSendConfig,
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        try{
            Log.i("CMM", "ENVIANDO DADOS")
            setStatusSendConfig(StatusSend.ENVIANDO)
            var result = sendDataBoletimMMFert()
            Log.i("CMM", "ENVIADO DADOS")
            result.onSuccess {
                Log.i("CMM", "RECEBENDO RETORNO")
                sentDataBoletimMMFert(it)
            }
            Log.i("CMM", "FINALIZADO ENVIO DE DADOS")
            setStatusSendConfig(StatusSend.ENVIADO)
            return Result.success()
        } catch (e: Exception){
            setStatusSendConfig(StatusSend.ENVIAR)
            return Result.retry()
        }
    }

}