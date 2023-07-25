package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.sharedpreferences.*
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SharedPreferencesDatasourceModule {

    @Singleton
    @Binds
    fun bindApontMMDatasourceSharedPreferences(dataSource: ApontMMDatasourceSharedPreferencesImpl): ApontMMDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindApontFertDatasourceSharedPreferences(dataSource: ApontFertDatasourceSharedPreferencesImpl): ApontFertDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindBoletimFertDatasourceSharedPreferences(dataSource: BoletimFertDatasourceSharedPreferencesImpl): BoletimFertDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindBoletimMMDatasourceSharedPreferences(dataSource: BoletimMMDatasourceSharedPreferencesImpl): BoletimMMDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindConfigDatasourceSharedPreferences(dataSource: ConfigDatasourceSharedPreferencesImpl): ConfigDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindImplementoDatasourceSharedPreferences(dataSource: ImplementoDatasourceSharedPreferencesImpl): ImplementoDatasourceSharedPreferences

}