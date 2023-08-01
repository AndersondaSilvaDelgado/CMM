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
    fun bindAddRespItemCheckList(usecase: AddRespItemCheckListImpl): AddRespItemCheckList

    @Singleton
    @Binds
    fun bindCheckDataSendCheckList(usecase: CheckDataSendCheckListImpl): CheckDataSendCheckList

    @Singleton
    @Binds
    fun bindCheckLastItemCheckList(usecase: CheckLastItemCheckListImpl): CheckLastItemCheckList

    @Singleton
    @Binds
    fun bindCheckOpenCheckList(usecase: CheckOpenCheckListImpl): CheckOpenCheckList

    @Singleton
    @Binds
    fun bindCheckUpdateCheckList(usecase: CheckUpdateCheckListImpl): CheckUpdateCheckList

    @Singleton
    @Binds
    fun bindCloseCheckList(usecase: CloseCheckListImpl): CloseCheckList

    @Singleton
    @Binds
    fun bindDeleteRespItemCheckList(usecase: DeleteRespItemCheckListImpl): DeleteRespItemCheckList

    @Singleton
    @Binds
    fun bindGetDescrItemCheckList(usecase: GetDescrItemCheckListImpl): GetDescrItemCheckList

    @Singleton
    @Binds
    fun bindOpenCheckList(usecase: OpenCheckListImpl): OpenCheckList

    @Singleton
    @Binds
    fun bindReceiverSentDataCheckList(usecase: ReceiverSentDataCheckListImpl): ReceiverSentDataCheckList

    @Singleton
    @Binds
    fun bindSendDataCheckList(usecase: SendDataCheckListImpl): SendDataCheckList

}