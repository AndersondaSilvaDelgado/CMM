package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource.ApontFertDatasourceSharedPreferencesImpl
import br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource.ApontMMDatasourceSharedPreferencesImpl
import br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource.BoletimFertDatasourceSharedPreferencesImpl
import br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource.BoletimMMDatasourceSharedPreferencesImpl
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ApontFertDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ApontMMDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.BoletimFertDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.BoletimMMDatasourceSharedPreferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MemoryDatasourceModule {

    @Singleton
    @Binds
    fun bindApontMMDatasourceMemory(dataSource: ApontMMDatasourceSharedPreferencesImpl): ApontMMDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindApontFertDatasourceMemory(dataSource: ApontFertDatasourceSharedPreferencesImpl): ApontFertDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindBoletimFertDatasource(dataSource: BoletimFertDatasourceSharedPreferencesImpl): BoletimFertDatasourceSharedPreferences

    @Singleton
    @Binds
    fun bindBoletimMMDatasource(dataSource: BoletimMMDatasourceSharedPreferencesImpl): BoletimMMDatasourceSharedPreferences

}