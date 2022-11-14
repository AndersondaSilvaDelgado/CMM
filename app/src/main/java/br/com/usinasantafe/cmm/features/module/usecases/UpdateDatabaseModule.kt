package br.com.usinasantafe.cmm.features.module.usecases

import br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase.*
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface UpdateDatabaseModule {

    @Singleton
    @Binds
    fun bindUpdateDataBase(usecase: UpdateDataBaseImpl): UpdateDataBase

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
    fun bindUpdateEquip(usecase: UpdateEquipImpl): UpdateEquip

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
    fun bindUpdateMotoMec(usecase: UpdateMotoMecImpl): UpdateMotoMec

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
    fun bindUpdateREquipAtiv(usecase: UpdateREquipAtivImpl): UpdateREquipAtiv

    @Singleton
    @Binds
    fun bindUpdateREquipPneu(usecase: UpdateREquipPneuImpl): UpdateREquipPneu

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