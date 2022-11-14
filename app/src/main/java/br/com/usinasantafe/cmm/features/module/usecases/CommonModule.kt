package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.common.CheckMatricOperadorImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.common.CheckUpdateImpl
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckMatricOperador
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckUpdate
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
    fun bindCheckOperador(usecase: CheckMatricOperadorImpl): CheckMatricOperador

    @Singleton
    @Binds
    fun bindCheckUpdateConfig(usecase: CheckUpdateImpl): CheckUpdate

}