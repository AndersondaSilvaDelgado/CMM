package br.com.usinasantafe.cmm.features.module.repository

import br.com.usinasantafe.cmm.features.domain.repositories.variable.*
import br.com.usinasantafe.cmm.features.infra.repositories.variable.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface VariableRepositoryModule {

    @Singleton
    @Binds
    fun bindApontMMFertRepository(repository: ApontMMFertRepositoryImpl): ApontMMFertRepository

    @Singleton
    @Binds
    fun bindBoletimMMFertRepository(repository: BoletimMMFertRepositoryImpl): BoletimMMFertRepository

    @Singleton
    @Binds
    fun bindCabecCheckListRepository(repository: CabecCheckListRepositoryImpl): CabecCheckListRepository

    @Singleton
    @Binds
    fun bindConfigRepository(repository: ConfigRepositoryImpl): ConfigRepository

    @Singleton
    @Binds
    fun bindRespItemCheckListRepository(repository: RespItemCheckListRepositoryImpl): RespItemCheckListRepository

}