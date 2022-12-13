package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface ApontMMFertModule {

    @Singleton
    @Binds
    fun bindListMenuECM(usecase: ListMenuECMImpl): ListMenuECM

    @Singleton
    @Binds
    fun bindListMenuPCOMP(usecase: ListMenuPCOMPImpl): ListMenuPCOMP

    @Singleton
    @Binds
    fun bindListMenuPMM(usecase: ListMenuPMMImpl): ListMenuPMM

    @Singleton
    @Binds
    fun bindSetApontTrabalhando(usecase: SetApontTrabalhandoImpl): SetApontTrabalhando

    @Singleton
    @Binds
    fun bindSetNroOSApontMMFert(usecase: SetNroOSApontMMFertImpl): SetNroOSApontMMFert

}