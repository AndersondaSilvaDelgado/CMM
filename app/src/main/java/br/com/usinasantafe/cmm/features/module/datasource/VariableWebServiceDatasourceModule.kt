package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.webservice.datasource.stable.AtividadeDatasourceWebServiceImpl
import br.com.usinasantafe.cmm.features.external.webservice.datasource.stable.BocalDatasourceWebServiceImpl
import br.com.usinasantafe.cmm.features.external.webservice.datasource.variable.ConfigDatasourceWebServiceImpl
import br.com.usinasantafe.cmm.features.external.webservice.datasource.variable.FertirrigacaoDatasourceWebServiceImpl
import br.com.usinasantafe.cmm.features.external.webservice.datasource.variable.MotoMecDatasourceWebServiceImpl
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.AtividadeDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.BocalDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.ConfigDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.FertirrigacaoDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.MotoMecDatasourceWebService
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
    fun bindFertirrigacaoDatasource(dataSource: FertirrigacaoDatasourceWebServiceImpl): FertirrigacaoDatasourceWebService

    @Singleton
    @Binds
    fun bindMotoMecDatasource(dataSource: MotoMecDatasourceWebServiceImpl): MotoMecDatasourceWebService

    @Singleton
    @Binds
    fun bindConfigDatasource(dataSource: ConfigDatasourceWebServiceImpl): ConfigDatasourceWebService

}