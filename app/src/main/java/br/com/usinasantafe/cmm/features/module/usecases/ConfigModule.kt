package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.config.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface ConfigModule {

    @Singleton
    @Binds
    fun bindCheckPasswordConfig(usecase: CheckPasswordConfigImpl): CheckPasswordConfig

    @Singleton
    @Binds
    fun bindHasConfig(usecase: HasConfigImpl): HasConfig

    @Singleton
    @Binds
    fun bindRecoverConfig(usecase: RecoverConfigImpl): RecoverConfig

    @Singleton
    @Binds
    fun bindSaveConfig(usecase: SaveConfigImpl): SaveConfig

    @Singleton
    @Binds
    fun bindSetStatusSendConfig(usecase: SetStatusSendConfigImpl): SetStatusSendConfig

}