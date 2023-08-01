package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.implementommfert.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface ImplementoMMFertModule {

    @Singleton
    @Binds
    fun bindAddImplementoBoletimMMFert(usecase: AddImplementoImpl): AddImplemento

    @Singleton
    @Binds
    fun bindCheckEmptyImplemento(usecase: CheckEmptyImplementoImpl): CheckEmptyImplemento

    @Singleton
    @Binds
    fun bindCheckImplemento(usecase: CheckImplementoImpl): CheckImplemento

    @Singleton
    @Binds
    fun bindClearDataImplemento(usecase: ClearDataImplementoImpl): ClearDataImplemento

    @Singleton
    @Binds
    fun bindPositionImplemento(usecase: PositionImplementoImpl): PositionImplemento

}