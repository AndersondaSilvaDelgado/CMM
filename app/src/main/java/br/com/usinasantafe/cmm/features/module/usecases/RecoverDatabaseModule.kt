package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RecoverDatabaseModule {

    @Singleton
    @Binds
    fun bindRecoverAtividade(usecase: RecoverAtividadeImpl): RecoverAtividade

    @Singleton
    @Binds
    fun bindRecoverCheckList(usecase: RecoverCheckListImpl): RecoverCheckList

    @Singleton
    @Binds
    fun bindRecoverEquip(usecase: RecoverEquipImpl): RecoverEquip

    @Singleton
    @Binds
    fun bindRecoverOS(usecase: RecoverOSImpl): RecoverOS

    @Singleton
    @Binds
    fun bindRecoverParada(usecase: RecoverParadaImpl): RecoverParada

    @Singleton
    @Binds
    fun bindRecoverREquipAtiv(usecase: RecoverREquipAtivImpl): RecoverREquipAtiv

    @Singleton
    @Binds
    fun bindRecoverREquipPneu(usecase: RecoverREquipPneuImpl): RecoverREquipPneu

    @Singleton
    @Binds
    fun bindRecoverROSAtiv(usecase: RecoverROSAtivImpl): RecoverROSAtiv

}