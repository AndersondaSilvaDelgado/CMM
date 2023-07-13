package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface CheckListModule {

    @Singleton
    @Binds
    fun bindCheckPasswordConfig(usecase: CheckAberturaCheckListImpl): CheckAberturaCheckList

    @Singleton
    @Binds
    fun bindCheckAtualCheckList(usecase: CheckAtualCheckListImpl): CheckAtualCheckList

    @Singleton
    @Binds
    fun bindOpenCheckList(usecase: OpenCheckListImpl): OpenCheckList

}