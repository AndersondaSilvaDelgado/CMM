package br.com.usinasantafe.cmm.features.module.datasource

import br.com.usinasantafe.cmm.features.external.room.datasource.variable.*
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface VariableRoomDatasourceModule {

    @Singleton
    @Binds
    fun bindApontMMDatasource(dataSource: ApontMMDatasourceRoomImpl): ApontMMDatasourceRoom

    @Singleton
    @Binds
    fun bindApontFertDatasource(dataSource: ApontFertDatasourceRoomImpl): ApontFertDatasourceRoom

    @Singleton
    @Binds
    fun bindBoletimFertDatasource(dataSource: BoletimFertDatasourceRoomImpl): BoletimFertDatasourceRoom

    @Singleton
    @Binds
    fun bindBoletimMMDatasource(dataSource: BoletimMMDatasourceRoomImpl): BoletimMMDatasourceRoom

    @Singleton
    @Binds
    fun bindCabecCheckListDatasource(dataSource: CabecCheckListDatasourceRoomImpl): CabecCheckListDatasourceRoom

    @Singleton
    @Binds
    fun bindRespItemCheckListDatasource(dataSource: RespItemCheckListDatasourceRoomImpl): RespItemCheckListDatasourceRoom

}