package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendData
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendDataImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface WorkManagerModule {

    @Singleton
    @Binds
    fun bindStartSentData(usecase: StartProcessSendDataImpl): StartProcessSendData

}