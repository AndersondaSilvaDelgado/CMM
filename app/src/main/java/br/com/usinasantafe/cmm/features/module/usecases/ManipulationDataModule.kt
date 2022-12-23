package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.UpdateAllDataBaseImpl
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover.*
import br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.UpdateAllDataBase
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface ManipulationDataModule {

    @Singleton
    @Binds
    fun bindRecoverAtividade(usecase: RecoverAtividadeImpl): RecoverAtividade

    @Singleton
    @Binds
    fun bindRecoverEquip(usecase: RecoverEquipImpl): RecoverEquip

    @Singleton
    @Binds
    fun bindRecoverOS(usecase: RecoverOSImpl): RecoverOS

    @Singleton
    @Binds
    fun bindRecoverREquipAtiv(usecase: RecoverREquipAtivImpl): RecoverREquipAtiv

    @Singleton
    @Binds
    fun bindRecoverREquipPneu(usecase: RecoverREquipPneuImpl): RecoverREquipPneu

    @Singleton
    @Binds
    fun bindRecoverROSAtiv(usecase: RecoverROSAtivImpl): RecoverROSAtiv

    @Singleton
    @Binds
    fun bindUpdateDataBase(usecase: UpdateAllDataBaseImpl): UpdateAllDataBase

    @Singleton
    @Binds
    fun bindUpdateAtividade(usecase: UpdateAtividadeImpl): UpdateAtividade

    @Singleton
    @Binds
    fun bindUpdateBocal(usecase: UpdateBocalImpl): UpdateBocal

    @Singleton
    @Binds
    fun bindUpdateComponente(usecase: UpdateComponenteImpl): UpdateComponente

    @Singleton
    @Binds
    fun bindUpdateEquipSeg(usecase: UpdateEquipSegImpl): UpdateEquipSeg

    @Singleton
    @Binds
    fun bindUpdateFrente(usecase: UpdateFrenteImpl): UpdateFrente

    @Singleton
    @Binds
    fun bindUpdateFunc(usecase: UpdateFuncImpl): UpdateFunc

    @Singleton
    @Binds
    fun bindUpdateItemCheckList(usecase: UpdateItemCheckListImpl): UpdateItemCheckList

    @Singleton
    @Binds
    fun bindUpdateItemOSMecan(usecase: UpdateItemOSMecanImpl): UpdateItemOSMecan

    @Singleton
    @Binds
    fun bindUpdateLeira(usecase: UpdateLeiraImpl): UpdateLeira

    @Singleton
    @Binds
    fun bindUpdateMotoMec(usecase: UpdateOperMotoMecImpl): UpdateOperMotoMec

    @Singleton
    @Binds
    fun bindUpdateOS(usecase: UpdateOSImpl): UpdateOS

    @Singleton
    @Binds
    fun bindUpdateParada(usecase: UpdateParadaImpl): UpdateParada

    @Singleton
    @Binds
    fun bindUpdatePneu(usecase: UpdatePneuImpl): UpdatePneu

    @Singleton
    @Binds
    fun bindUpdatePressaoBocal(usecase: UpdatePressaoBocalImpl): UpdatePressaoBocal

    @Singleton
    @Binds
    fun bindUpdateProduto(usecase: UpdateProdutoImpl): UpdateProduto

    @Singleton
    @Binds
    fun bindUpdatePropriedade(usecase: UpdatePropriedadeImpl): UpdatePropriedade

    @Singleton
    @Binds
    fun bindUpdateRAtivParada(usecase: UpdateRAtivParadaImpl): UpdateRAtivParada

    @Singleton
    @Binds
    fun bindUpdateRFuncaoAtivParada(usecase: UpdateRFuncaoAtivParadaImpl): UpdateRFuncaoAtivParada

    @Singleton
    @Binds
    fun bindUpdateROSAtiv(usecase: UpdateROSAtivImpl): UpdateROSAtiv

    @Singleton
    @Binds
    fun bindUpdateServico(usecase: UpdateServicoImpl): UpdateServico

    @Singleton
    @Binds
    fun bindUpdateTurno(usecase: UpdateTurnoImpl): UpdateTurno

}