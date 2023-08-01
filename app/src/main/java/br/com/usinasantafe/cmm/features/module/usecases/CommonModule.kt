package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.common.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.*
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
    fun bindCheckStatusSend(usecase: CheckStatusSendImpl): CheckStatusSend

    @Singleton
    @Binds
    fun bindCheckUpdate(usecase: CheckUpdateImpl): CheckUpdate

    @Singleton
    @Binds
    fun bindClearDataMotoMec(usecase: ClearDataMotoMecImpl): ClearDataMotoMec

    @Singleton
    @Binds
    fun bindGetEquipConfig(usecase: GetEquipConfigImpl): GetEquipConfig

    @Singleton
    @Binds
    fun bindGetHorimetroEquip(usecase: GetHorimetroEquipImpl): GetHorimetroEquip

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
    fun bindSendDataAPPUpdateFert(usecase: SendDataAppUpdateImpl): SendDataAppUpdate

    @Singleton
    @Binds
    fun bindSentDataAPPUpdateFert(usecase: SentDataAppUpdateImpl): SentDataAppUpdate

    @Singleton
    @Binds
    fun bindSetHorimetroEquip(usecase: SetHorimetroEquipImpl): SetHorimetroEquip

    @Singleton
    @Binds
    fun bindStartAPP(usecase: StartAppImpl): StartApp

}