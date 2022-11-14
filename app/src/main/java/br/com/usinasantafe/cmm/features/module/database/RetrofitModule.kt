package br.com.usinasantafe.cmm.features.module.database

import br.com.usinasantafe.cmm.features.external.webservice.AppRetrofit
import br.com.usinasantafe.cmm.features.external.webservice.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun atividadeRetrofit(): AtividadeApi {
        return AppRetrofit.getInstance().create(AtividadeApi::class.java)
    }

    @Singleton
    @Provides
    fun bocalRetrofit(): BocalApi {
        return AppRetrofit.getInstance().create(BocalApi::class.java)
    }

    @Singleton
    @Provides
    fun componenteRetrofit(): ComponenteApi {
        return AppRetrofit.getInstance().create(ComponenteApi::class.java)
    }

    @Singleton
    @Provides
    fun equipRetrofit(): EquipApi {
        return AppRetrofit.getInstance().create(EquipApi::class.java)
    }

    @Singleton
    @Provides
    fun equipSegRetrofit(): EquipSegApi {
        return AppRetrofit.getInstance().create(EquipSegApi::class.java)
    }

    @Singleton
    @Provides
    fun frenteRetrofit(): FrenteApi {
        return AppRetrofit.getInstance().create(FrenteApi::class.java)
    }

    @Singleton
    @Provides
    fun funcRetrofit(): FuncApi {
        return AppRetrofit.getInstance().create(FuncApi::class.java)
    }

    @Singleton
    @Provides
    fun itemCheckListRetrofit(): ItemCheckListApi {
        return AppRetrofit.getInstance().create(ItemCheckListApi::class.java)
    }

    @Singleton
    @Provides
    fun itemOSMecanApiRetrofit(): ItemOSMecanApi {
        return AppRetrofit.getInstance().create(ItemOSMecanApi::class.java)
    }

    @Singleton
    @Provides
    fun leiraApiRetrofit(): LeiraApi {
        return AppRetrofit.getInstance().create(LeiraApi::class.java)
    }

    @Singleton
    @Provides
    fun motoMecRetrofit(): MotoMecApi {
        return AppRetrofit.getInstance().create(MotoMecApi::class.java)
    }

    @Singleton
    @Provides
    fun osRetrofit(): OSApi {
        return AppRetrofit.getInstance().create(OSApi::class.java)
    }

    @Singleton
    @Provides
    fun paradaRetrofit(): ParadaApi {
        return AppRetrofit.getInstance().create(ParadaApi::class.java)
    }

    @Singleton
    @Provides
    fun pneuRetrofit(): PneuApi {
        return AppRetrofit.getInstance().create(PneuApi::class.java)
    }

    @Singleton
    @Provides
    fun pressaoBocalRetrofit(): PressaoBocalApi {
        return AppRetrofit.getInstance().create(PressaoBocalApi::class.java)
    }

    @Singleton
    @Provides
    fun produtoRetrofit(): ProdutoApi {
        return AppRetrofit.getInstance().create(ProdutoApi::class.java)
    }

    @Singleton
    @Provides
    fun propriedadeRetrofit(): PropriedadeApi {
        return AppRetrofit.getInstance().create(PropriedadeApi::class.java)
    }

    @Singleton
    @Provides
    fun rAtivParadaRetrofit(): RAtivParadaApi {
        return AppRetrofit.getInstance().create(RAtivParadaApi::class.java)
    }

    @Singleton
    @Provides
    fun rEquipAtivRetrofit(): REquipAtivApi {
        return AppRetrofit.getInstance().create(REquipAtivApi::class.java)
    }

    @Singleton
    @Provides
    fun rEquipPneuRetrofit(): REquipPneuApi {
        return AppRetrofit.getInstance().create(REquipPneuApi::class.java)
    }

    @Singleton
    @Provides
    fun rFuncaoAtivParadaRetrofit(): RFuncaoAtivParadaApi {
        return AppRetrofit.getInstance().create(RFuncaoAtivParadaApi::class.java)
    }

    @Singleton
    @Provides
    fun rOSAtivRetrofit(): ROSAtivApi {
        return AppRetrofit.getInstance().create(ROSAtivApi::class.java)
    }

    @Singleton
    @Provides
    fun servicoRetrofit(): ServicoApi {
        return AppRetrofit.getInstance().create(ServicoApi::class.java)
    }

    @Singleton
    @Provides
    fun turnoRetrofit(): TurnoApi {
        return AppRetrofit.getInstance().create(TurnoApi::class.java)
    }

}