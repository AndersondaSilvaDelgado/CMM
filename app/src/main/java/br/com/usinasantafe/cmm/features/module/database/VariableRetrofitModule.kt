package br.com.usinasantafe.cmm.features.module.database

import br.com.usinasantafe.cmm.features.external.webservice.AppRetrofit
import br.com.usinasantafe.cmm.features.external.webservice.api.variable.CheckListApi
import br.com.usinasantafe.cmm.features.external.webservice.api.variable.ConfigApi
import br.com.usinasantafe.cmm.features.external.webservice.api.variable.FertirrigacaoApi
import br.com.usinasantafe.cmm.features.external.webservice.api.variable.MotoMecApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VariableRetrofitModule {

    @Singleton
    @Provides
    fun checkListApiRetrofit(): CheckListApi {
        return AppRetrofit.getInstance().create(CheckListApi::class.java)
    }

    @Singleton
    @Provides
    fun configApiRetrofit(): ConfigApi {
        return AppRetrofit.getInstance().create(ConfigApi::class.java)
    }

    @Singleton
    @Provides
    fun fertirrigacaoRetrofit(): FertirrigacaoApi {
        return AppRetrofit.getInstance().create(FertirrigacaoApi::class.java)
    }

    @Singleton
    @Provides
    fun motoMecApiRetrofit(): MotoMecApi {
        return AppRetrofit.getInstance().create(MotoMecApi::class.java)
    }

}