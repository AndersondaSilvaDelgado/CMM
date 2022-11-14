package br.com.usinasantafe.cmm.features.module.database

import android.content.Context
import androidx.room.Room
import br.com.usinasantafe.cmm.common.utils.BASE_DB
import br.com.usinasantafe.cmm.features.external.room.AppDatabaseRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabaseRoom {
        return Room.databaseBuilder(
            appContext,
            AppDatabaseRoom::class.java,
            BASE_DB
        ).build()
    }

}