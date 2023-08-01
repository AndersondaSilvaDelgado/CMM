package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.webservice.datasource.variable.*
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface VariableWebServiceDatasourceModule {

    @Singleton
    @Binds
    fun bindCheckListDatasourceWebService(dataSource: CheckListDatasourceWebServiceImpl): CheckListDatasourceWebService

    @Singleton
    @Binds
    fun bindConfigDatasourceWebService(dataSource: ConfigDatasourceWebServiceImpl): ConfigDatasourceWebService

    @Singleton
    @Binds
    fun bindFertirrigacaoDatasourceWebService(dataSource: FertirrigacaoDatasourceWebServiceImpl): FertirrigacaoDatasourceWebService

    @Singleton
    @Binds
    fun bindMotoMecDatasourceWebService(dataSource: MotoMecDatasourceWebServiceImpl): MotoMecDatasourceWebService

}