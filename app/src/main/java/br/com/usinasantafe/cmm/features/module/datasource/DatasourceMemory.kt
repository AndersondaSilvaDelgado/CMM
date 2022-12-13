package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.memory.datasource.*
import br.com.usinasantafe.cmm.features.infra.datasource.memory.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatasourceMemory {

    @Singleton
    @Binds
    fun bindApontMMDatasourceMemory(dataSource: ApontMMDatasourceMemoryImpl): ApontMMDatasourceMemory

    @Singleton
    @Binds
    fun bindApontFertDatasourceMemory(dataSource: ApontFertDatasourceMemoryImpl): ApontFertDatasourceMemory

    @Singleton
    @Binds
    fun bindBoletimFertDatasource(dataSource: BoletimFertDatasourceMemoryImpl): BoletimFertDatasourceMemory

    @Singleton
    @Binds
    fun bindBoletimMMDatasource(dataSource: BoletimMMDatasourceMemoryImpl): BoletimMMDatasourceMemory

}