package br.com.usinasantafe.cmm.features.module.dao

import br.com.usinasantafe.cmm.features.external.room.AppDatabaseRoom
import br.com.usinasantafe.cmm.features.external.room.dao.variable.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VariableDaoRoomModule {

    @Singleton
    @Provides
    fun provideApontFertDao(database: AppDatabaseRoom): ApontFertDao {
        return database.apontFertDao()
    }

    @Singleton
    @Provides
    fun provideApontMMDao(database: AppDatabaseRoom): ApontMMDao {
        return database.apontMMDao()
    }

    @Singleton
    @Provides
    fun provideBoletimFertDao(database: AppDatabaseRoom): BoletimFertDao {
        return database.boletimFertDao()
    }

    @Singleton
    @Provides
    fun provideBoletimMMDao(database: AppDatabaseRoom): BoletimMMDao {
        return database.boletimMMDao()
    }

    @Singleton
    @Provides
    fun provideCabecCheckListDao(database: AppDatabaseRoom): CabecCheckListDao {
        return database.cabecCheckListDao()
    }

    @Singleton
    @Provides
    fun provideRespItemCheckListDao(database: AppDatabaseRoom): RespItemCheckListDao {
        return database.respItemCheckListDao()
    }

}