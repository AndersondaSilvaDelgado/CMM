package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert.SendDataBoletimMMFertImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert.SentDataBoletimMMFertImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.common.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SendDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SentDataBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.*
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendData
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendDataImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface CommonModule {

    @Singleton
    @Binds
    fun bindCheckMatricOperador(usecase: CheckMatricOperadorImpl): CheckMatricOperador

    @Singleton
    @Binds
    fun bindCheckNroOS(usecase: CheckNroOSImpl): CheckNroOS

    @Singleton
    @Binds
    fun bindCheckSendBoletimMM(usecase: CheckSendBoletimMMImpl): CheckSendBoletimMM

    @Singleton
    @Binds
    fun bindCheckSendData(usecase: CheckSendDataImpl): CheckSendData

    @Singleton
    @Binds
    fun bindCheckUpdate(usecase: CheckUpdateImpl): CheckUpdate

    @Singleton
    @Binds
    fun bindGetNroEquipConfig(usecase: GetEquipConfigImpl): GetEquipConfig

    @Singleton
    @Binds
    fun bindGetOSNroConfig(usecase: GetOSNroImpl): GetOSNro

    @Singleton
    @Binds
    fun bindListAtiv(usecase: ListAtivImpl): ListAtiv

    @Singleton
    @Binds
    fun bindListTurno(usecase: ListTurnoImpl): ListTurno

    @Singleton
    @Binds
    fun bindSendDataBoletimMMFert(usecase: SendDataBoletimMMFertImpl): SendDataBoletimMMFert

    @Singleton
    @Binds
    fun bindSentDataBoletimMMFert(usecase: SentDataBoletimMMFertImpl): SentDataBoletimMMFert

    @Singleton
    @Binds
    fun bindStartSentData(usecase: StartSendDataImpl): StartSendData

}