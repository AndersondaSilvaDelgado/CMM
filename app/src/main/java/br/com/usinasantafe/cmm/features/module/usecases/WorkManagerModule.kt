package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendData
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendDataImpl
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
    fun bindStartSentData(usecase: StartSendDataImpl): StartSendData

}