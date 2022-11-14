package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert.SetMatricFuncBoletimMMFertImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert.StartBoletimMMFertImpl
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetMatricFuncBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.StartBoletimMMFert
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
    fun bindSetMatricFuncBoletimMMFert(usecase: SetMatricFuncBoletimMMFertImpl): SetMatricFuncBoletimMMFert

    @Singleton
    @Binds
    fun bindStartBoletimMMFert(usecase: StartBoletimMMFertImpl): StartBoletimMMFert

}