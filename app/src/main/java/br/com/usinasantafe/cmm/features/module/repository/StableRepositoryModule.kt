package br.com.usinasantafe.cmm.features.module.repository

import br.com.usinasantafe.cmm.features.domain.repositories.stable.*
import br.com.usinasantafe.cmm.features.infra.repositories.stable.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface StableRepositoryModule {

    @Singleton
    @Binds
    fun bindAtividadeRepository(repository: AtivRepositoryImpl): AtivRepository

    @Singleton
    @Binds
    fun bindBocalRepository(repository: BocalRepositoryImpl): BocalRepository

    @Singleton
    @Binds
    fun bindComponenteRepository(repository: ComponenteRepositoryImpl): ComponenteRepository

    @Singleton
    @Binds
    fun bindEquipRepository(repository: EquipRepositoryImpl): EquipRepository

    @Singleton
    @Binds
    fun bindEquipSegRepository(repository: EquipSegRepositoryImpl): EquipSegRepository

    @Singleton
    @Binds
    fun bindFrenteRepository(repository: FrenteRepositoryImpl): FrenteRepository

    @Singleton
    @Binds
    fun bindFuncRepository(repository: FuncRepositoryImpl): FuncRepository

    @Singleton
    @Binds
    fun bindItemCheckListRepository(repository: ItemCheckListRepositoryImpl): ItemCheckListRepository

    @Singleton
    @Binds
    fun bindItemOSMecantRepository(repository: ItemOSMecanRepositoryImpl): ItemOSMecanRepository

    @Singleton
    @Binds
    fun bindLeiraRepository(repository: LeiraRepositoryImpl): LeiraRepository

    @Singleton
    @Binds
    fun bindMotoMecRepository(repository: OperMotoMecRepostioryImpl): OperMotoMecRepository

    @Singleton
    @Binds
    fun bindOSRepository(repository: OSRepositoryImpl): OSRepository

    @Singleton
    @Binds
    fun bindParadaRepository(repository: ParadaRepositoryImpl): ParadaRepository

    @Singleton
    @Binds
    fun bindPneuRepository(repository: PneuRepositoryImpl): PneuRepository

    @Singleton
    @Binds
    fun bindPressaoBocalRepository(repository: PressaoBocalRepositoryImpl): PressaoBocalRepository

    @Singleton
    @Binds
    fun bindProdutoRepository(repository: ProdutoRepositoryImpl): ProdutoRepository

    @Singleton
    @Binds
    fun bindPropriedadeRepository(repository: PropriedadeRepositoryImpl): PropriedadeRepository

    @Singleton
    @Binds
    fun bindRAtivParadaRepository(repository: RAtivParadaRepositoryImpl): RAtivParadaRepository

    @Singleton
    @Binds
    fun bindREquipAtivRepository(repository: REquipAtivRepositoryImpl): REquipAtivRepository

    @Singleton
    @Binds
    fun bindREquipPneuRepository(repository: REquipPneuRepositoryImpl): REquipPneuRepository

    @Singleton
    @Binds
    fun bindRFuncaoAtivParadaRepository(repository: RFuncaoAtivParadaRepositoryImpl): RFuncaoAtivParadaRepository

    @Singleton
    @Binds
    fun bindROSAtivRepository(repository: ROSAtivRepositoryImpl): ROSAtivRepository

    @Singleton
    @Binds
    fun bindServicoRepository(repository: ServicoRepositoryImpl): ServicoRepository

    @Singleton
    @Binds
    fun bindTurnoRepository(repository: TurnoRepositoryImpl): TurnoRepository
}