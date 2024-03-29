package br.com.usinasantafe.cmm.features.domain.usecases.workmanager

import androidx.work.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckStatusSend
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class StartProcessSendDataImpl @Inject constructor(
    private val workManager: WorkManager,
    private val checkStatusSend: CheckStatusSend,
) : StartProcessSendData {

    override suspend fun invoke() {
        if(checkStatusSend()){
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