package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.webservice.datasource.*
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatasourceWebServiceModule {

    @Singleton
    @Binds
    fun bindAtividadeDatasource(dataSource: AtividadeDatasourceWebServiceImpl): AtividadeDatasourceWebService

    @Singleton
    @Binds
    fun bindBocalDatasource(dataSource: BocalDatasourceWebServiceImpl): BocalDatasourceWebService

    @Singleton
    @Binds
    fun bindComponenteDatasource(dataSource: ComponenteDatasourceWebServiceImpl): ComponenteDatasourceWebService

    @Singleton
    @Binds
    fun bindEquipDatasource(dataSource: EquipDatasourceWebServiceImpl): EquipDatasourceWebService

    @Singleton
    @Binds
    fun bindEquipSegDatasource(dataSource: EquipSegDatasourceWebServiceImpl): EquipSegDatasourceWebService

    @Singleton
    @Binds
    fun bindFrenteDatasource(dataSource: FrenteDatasourceWebServiceImpl): FrenteDatasourceWebService

    @Singleton
    @Binds
    fun bindFuncDatasource(dataSource: FuncDatasourceWebServiceImpl): FuncDatasourceWebService

    @Singleton
    @Binds
    fun bindItemCheckListDatasource(dataSource: ItemCheckListDatasourceWebServiceImpl): ItemCheckListDatasourceWebService

    @Singleton
    @Binds
    fun bindItemOSMecanDatasource(dataSource: ItemOSMecanDatasourceWebServiceImpl): ItemOSMecanDatasourceWebService

    @Singleton
    @Binds
    fun bindLeiraDatasource(dataSource: LeiraDatasourceWebServiceImpl): LeiraDatasourceWebService

    @Singleton
    @Binds
    fun bindMotoMecDatasource(dataSource: MotoMecDatasourceWebServiceImpl): MotoMecDatasourceWebService

    @Singleton
    @Binds
    fun bindOSDatasource(dataSource: OSDatasourceWebServiceImpl): OSDatasourceWebService

    @Singleton
    @Binds
    fun bindParadaDatasource(dataSource: ParadaDatasourceWebServiceImpl): ParadaDatasourceWebService

    @Singleton
    @Binds
    fun bindPneuDatasource(dataSource: PneuDatasourceWebServiceImpl): PneuDatasourceWebService

    @Singleton
    @Binds
    fun bindPressaoBocalDatasource(dataSource: PressaoBocalDatasourceWebServiceImpl): PressaoBocalDatasourceWebService

    @Singleton
    @Binds
    fun bindProdutoDatasource(dataSource: ProdutoDatasourceWebServiceImpl): ProdutoDatasourceWebService

    @Singleton
    @Binds
    fun bindPropriedadeDatasource(dataSource: PropriedadeDatasourceWebServiceImpl): PropriedadeDatasourceWebService

    @Singleton
    @Binds
    fun bindRAtivParadaDatasource(dataSource: RAtivParadaDatasourceWebServiceImpl): RAtivParadaDatasourceWebService

    @Singleton
    @Binds
    fun bindREquipAtivDatasource(dataSource: REquipAtivDatasourceWebServiceImpl): REquipAtivDatasourceWebService

    @Singleton
    @Binds
    fun bindREquipPneuDatasource(dataSource: REquipPneuDatasourceWebServiceImpl): REquipPneuDatasourceWebService

    @Singleton
    @Binds
    fun bindRFuncaoAtivParadaDatasource(dataSource: RFuncaoAtivParadaDatasourceWebServiceImpl): RFuncaoAtivParadaDatasourceWebService

    @Singleton
    @Binds
    fun bindROSAtivDatasource(dataSource: ROSAtivDatasourceWebServiceImpl): ROSAtivDatasourceWebService

    @Singleton
    @Binds
    fun bindServicoDatasource(dataSource: ServicoDatasourceWebServiceImpl): ServicoDatasourceWebService

    @Singleton
    @Binds
    fun bindTurnoDatasource(dataSource: TurnoDatasourceWebServiceImpl): TurnoDatasourceWebService

}