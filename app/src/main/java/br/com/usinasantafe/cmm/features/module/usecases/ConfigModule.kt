package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.common.CheckUpdateImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.config.CheckPasswordConfigImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.config.HasConfigImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.config.RecoverConfigImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.config.SaveConfigImpl
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckUpdate
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.CheckPasswordConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.HasConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SaveConfig
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

}