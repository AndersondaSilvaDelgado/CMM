package br.com.usinasantafe.cmm.features.domain.usecases.workmanager

import androidx.work.*
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckSendData
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SetStatusSendConfig
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class StartSendDataImpl @Inject constructor(
    private val workManager: WorkManager,
    private val checkSendData: CheckSendData,
    private val setStatusSendConfig: SetStatusSendConfig
) : StartSendData {

    override suspend fun invoke() {
        if(checkSendData()){
            setStatusSendConfig(StatusSend.ENVIAR)
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true)
                .build()
            val workRequest = OneTimeWorkRequest.Builder(ProcessWorkManager::class.java)
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    2, TimeUnit.MINUTES
                )
                .build()
            workManager.enqueue(workRequest)
        }
    }

}