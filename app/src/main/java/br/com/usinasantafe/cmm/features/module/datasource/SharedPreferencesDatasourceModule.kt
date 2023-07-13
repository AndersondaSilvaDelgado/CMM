package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource.ConfigDatasourceSharedPreferencesImpl
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ConfigDatasourceSharedPreferences
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
    fun bindConfigDatasource(dataSource: ConfigDatasourceSharedPreferencesImpl): ConfigDatasourceSharedPreferences

}