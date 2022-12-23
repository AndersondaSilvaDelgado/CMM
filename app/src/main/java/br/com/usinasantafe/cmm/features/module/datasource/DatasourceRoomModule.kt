package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.room.datasource.stable.*
import br.com.usinasantafe.cmm.features.external.room.datasource.variable.ApontFertDatasourceRoomImpl
import br.com.usinasantafe.cmm.features.external.room.datasource.variable.ApontMMDatasourceRoomImpl
import br.com.usinasantafe.cmm.features.external.room.datasource.variable.BoletimFertDatasourceRoomImpl
import br.com.usinasantafe.cmm.features.external.room.datasource.variable.BoletimMMDatasourceRoomImpl
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.*
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.ApontMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatasourceRoomModule {

    @Singleton
    @Binds
    fun bindApontMMDatasource(dataSource: ApontMMDatasourceRoomImpl): ApontMMDatasourceRoom

    @Singleton
    @Binds
    fun bindApontFertDatasource(dataSource: ApontFertDatasourceRoomImpl): ApontFertDatasourceRoom

    @Singleton
    @Binds
    fun bindAtividadeDatasource(dataSource: AtividadeDatasourceRoomImpl): AtividadeDatasourceRoom

    @Singleton
    @Binds
    fun bindBocalDatasource(dataSource: BocalDatasourceRoomImpl): BocalDatasourceRoom

    @Singleton
    @Binds
    fun bindBoletimFertDatasource(dataSource: BoletimFertDatasourceRoomImpl): BoletimFertDatasourceRoom

    @Singleton
    @Binds
    fun bindBoletimMMDatasource(dataSource: BoletimMMDatasourceRoomImpl): BoletimMMDatasourceRoom

    @Singleton
    @Binds
    fun bindComponenteDatasource(dataSource: ComponenteDatasourceRoomImpl): ComponenteDatasourceRoom

    @Singleton
    @Binds
    fun bindEquipDatasource(dataSource: EquipDatasourceRoomImpl): EquipDatasourceRoom

    @Singleton
    @Binds
    fun bindEquipSegDatasource(dataSource: EquipSegDatasourceRoomImpl): EquipSegDatasourceRoom

    @Singleton
    @Binds
    fun bindFrenteDatasource(dataSource: FrenteDatasourceRoomImpl): FrenteDatasourceRoom

    @Singleton
    @Binds
    fun bindFuncDatasource(dataSource: FuncDatasourceRoomImpl): FuncDatasourceRoom

    @Singleton
    @Binds
    fun bindItemCheckListDatasource(dataSource: ItemCheckListDatasourceRoomImpl): ItemCheckListDatasourceRoom

    @Singleton
    @Binds
    fun bindItemOSMecanDatasource(dataSource: ItemOSMecanDatasourceRoomImpl): ItemOSMecanDatasourceRoom

    @Singleton
    @Binds
    fun bindLeiraDatasource(dataSource: LeiraDatasourceRoomImpl): LeiraDatasourceRoom

    @Singleton
    @Binds
    fun bindMotoMecDatasource(dataSource: OperMotoMecDatasourceRoomImpl): OperMotoMecDatasourceRoom

    @Singleton
    @Binds
    fun bindOSDatasource(dataSource: OSDatasourceRoomImpl): OSDatasourceRoom

    @Singleton
    @Binds
    fun bindParadaDatasource(dataSource: ParadaDatasourceRoomImpl): ParadaDatasourceRoom

    @Singleton
    @Binds
    fun bindPneuDatasource(dataSource: PneuDatasourceRoomImpl): PneuDatasourceRoom

    @Singleton
    @Binds
    fun bindPressaoBocalDatasource(dataSource: PressaoBocalDatasourceRoomImpl): PressaoBocalDatasourceRoom

    @Singleton
    @Binds
    fun bindProdutoDatasource(dataSource: ProdutoDatasourceRoomImpl): ProdutoDatasourceRoom

    @Singleton
    @Binds
    fun bindPropriedadeDatasource(dataSource: PropriedadeDatasourceRoomImpl): PropriedadeDatasourceRoom

    @Singleton
    @Binds
    fun bindRAtivParadaDatasource(dataSource: RAtivParadaDatasourceRoomImpl): RAtivParadaDatasourceRoom

    @Singleton
    @Binds
    fun bindREquipAtivDatasource(dataSource: REquipAtivDatasourceRoomImpl): REquipAtivDatasourceRoom

    @Singleton
    @Binds
    fun bindREquipPneuDatasource(dataSource: REquipPneuDatasourceRoomImpl): REquipPneuDatasourceRoom

    @Singleton
    @Binds
    fun bindRFuncaoAtivParadaDatasource(dataSource: RFuncaoAtivParadaDatasourceRoomImpl): RFuncaoAtivParadaDatasourceRoom

    @Singleton
    @Binds
    fun bindROSAtivDatasource(dataSource: ROSAtivDatasourceRoomImpl): ROSAtivDatasourceRoom

    @Singleton
    @Binds
    fun bindServicoDatasource(dataSource: ServicoDatasourceRoomImpl): ServicoDatasourceRoom

    @Singleton
    @Binds
    fun bindTurnoDatasource(dataSource: TurnoDatasourceRoomImpl): TurnoDatasourceRoom

}