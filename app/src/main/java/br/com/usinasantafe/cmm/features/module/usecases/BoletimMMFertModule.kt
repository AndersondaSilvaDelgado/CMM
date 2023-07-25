package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface BoletimMMFertModule {

    @Singleton
    @Binds
    fun bindAddImplementoBoletimMMFert(usecase: AddImplementoBoletimMMFertImpl): AddImplementoBoletimMMFert

    @Singleton
    @Binds
    fun bindCheckAbertoBoletimMMFert(usecase: CheckAbertoBoletimMMFertImpl): CheckAbertoBoletimMMFert

    @Singleton
    @Binds
    fun bindCheckHorimetroBoletimMMFert(usecase: CheckHorimetroBoletimMMFertImpl): CheckHorimetroBoletimMMFert

    @Singleton
    @Binds
    fun bindCheckImplementoBoletimMMFert(usecase: CheckImplementoBoletimMMFertImpl): CheckImplementoBoletimMMFert

    @Singleton
    @Binds
    fun bindRecoverNroOSBoletimMMFert(usecase: RecoverNroOSBoletimMMFertImpl): RecoverNroOSBoletimMMFert

    @Singleton
    @Binds
    fun bindSendDataBoletimMMFert(usecase: SendDataBoletimMMFertImpl): SendDataBoletimMMFert

    @Singleton
    @Binds
    fun bindSentDataBoletimMMFert(usecase: SentDataBoletimMMFertImpl): SentDataBoletimMMFert

    @Singleton
    @Binds
    fun bindSetHorimetroFinalBoletimMMFert(usecase: SetHorimetroFinalBoletimMMFertImpl): SetHorimetroFinalBoletimMMFert

    @Singleton
    @Binds
    fun bindSetHorimetroInicialBoletimMMFert(usecase: SetHorimetroInicialBoletimMMFertImpl): SetHorimetroInicialBoletimMMFert

    @Singleton
    @Binds
    fun bindSetIdAtivBoletimMMFert(usecase: SetIdAtivBoletimMMFertImpl): SetIdAtivBoletimMMFert

    @Singleton
    @Binds
    fun bindSetIdTurnoBoletimMMFert(usecase: SetIdTurnoBoletimMMFertImpl): SetIdTurnoBoletimMMFert

    @Singleton
    @Binds
    fun bindSetMatricFuncBoletimMMFert(usecase: SetMatricFuncBoletimMMFertImpl): SetMatricFuncBoletimMMFert

    @Singleton
    @Binds
    fun bindSetNroOSBoletimMMFert(usecase: SetNroOSBoletimMMFertImpl): SetNroOSBoletimMMFert

    @Singleton
    @Binds
    fun bindStartBoletimMMFert(usecase: StartBoletimMMFertImpl): StartBoletimMMFert

}