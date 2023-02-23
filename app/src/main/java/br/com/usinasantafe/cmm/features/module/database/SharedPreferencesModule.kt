package br.com.usinasantafe.cmm.features.module.database

import android.content.Context
import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_CONFIG
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences {
        return appContext.getSharedPreferences(BASE_SHARE_PREFERENCES, Context.MODE_PRIVATE)
    }

}