package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.memory.datasource.BoletimMMFertDatasourceMemoryImpl
import br.com.usinasantafe.cmm.features.infra.datasource.memory.BoletimMMFertDatasourceMemory
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
    fun bindBoletimMMFertDatasource(dataSource: BoletimMMFertDatasourceMemoryImpl): BoletimMMFertDatasourceMemory

}