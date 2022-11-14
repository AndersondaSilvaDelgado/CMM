package br.com.usinasantafe.cmm.features.module.dao

import br.com.usinasantafe.cmm.features.external.room.AppDatabaseRoom
import br.com.usinasantafe.cmm.features.external.room.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoRoomModule {

    @Singleton
    @Provides
    fun provideAtividadeDao(database: AppDatabaseRoom): AtividadeDao {
        return database.atividadeDao()
    }

    @Singleton
    @Provides
    fun provideBocaolDao(database: AppDatabaseRoom): BocalDao {
        return database.bocalDao()
    }

    @Singleton
    @Provides
    fun provideComponenteDao(database: AppDatabaseRoom): ComponenteDao {
        return database.componenteDao()
    }

    @Singleton
    @Provides
    fun provideEquipDao(database: AppDatabaseRoom): EquipDao {
        return database.equipDao()
    }

    @Singleton
    @Provides
    fun provideEquipSegDao(database: AppDatabaseRoom): EquipSegDao {
        return database.equipSegDao()
    }

    @Singleton
    @Provides
    fun provideFrenteDao(database: AppDatabaseRoom): FrenteDao {
        return database.frenteDao()
    }

    @Singleton
    @Provides
    fun provideFuncDao(database: AppDatabaseRoom): FuncDao {
        return database.funcDao()
    }

    @Singleton
    @Provides
    fun provideItemCheckListDao(database: AppDatabaseRoom): ItemCheckListDao {
        return database.itemCheckListDao()
    }

    @Singleton
    @Provides
    fun provideItemOSMecanDao(database: AppDatabaseRoom): ItemOSMecanDao {
        return database.itemOSMecanDao()
    }

    @Singleton
    @Provides
    fun provideLeiraDao(database: AppDatabaseRoom): LeiraDao {
        return database.leiraDao()
    }

    @Singleton
    @Provides
    fun provideMotoMecDao(database: AppDatabaseRoom): MotoMecDao {
        return database.motoMecDao()
    }

    @Singleton
    @Provides
    fun provideOSDao(database: AppDatabaseRoom): OSDao {
        return database.osDao()
    }

    @Singleton
    @Provides
    fun provideParadaDao(database: AppDatabaseRoom): ParadaDao {
        return database.paradaDao()
    }

    @Singleton
    @Provides
    fun providePneuDao(database: AppDatabaseRoom): PneuDao {
        return database.pneuDao()
    }

    @Singleton
    @Provides
    fun providePressaoBocalDao(database: AppDatabaseRoom): PressaoBocalDao {
        return database.pressaoBocalDao()
    }

    @Singleton
    @Provides
    fun provideProdutoDao(database: AppDatabaseRoom): ProdutoDao {
        return database.produtoDao()
    }

    @Singleton
    @Provides
    fun providePropriedadeDao(database: AppDatabaseRoom): PropriedadeDao {
        return database.propriedadeDao()
    }

    @Singleton
    @Provides
    fun provideRAtivParadaDao(database: AppDatabaseRoom): RAtivParadaDao {
        return database.rAtivParadaDao()
    }

    @Singleton
    @Provides
    fun provideREquipAtivDao(database: AppDatabaseRoom): REquipAtivDao {
        return database.rEquipAtivDao()
    }

    @Singleton
    @Provides
    fun provideREquipPneuDao(database: AppDatabaseRoom): REquipPneuDao {
        return database.rEquipPneuDao()
    }

    @Singleton
    @Provides
    fun provideRFuncaoAtivParadaDao(database: AppDatabaseRoom): RFuncaoAtivParadaDao {
        return database.rFuncaoAtivParadaDao()
    }

    @Singleton
    @Provides
    fun provideROSAtivDao(database: AppDatabaseRoom): ROSAtivDao {
        return database.rOSAtivDao()
    }

    @Singleton
    @Provides
    fun provideServicoDao(database: AppDatabaseRoom): ServicoDao {
        return database.servicoDao()
    }

    @Singleton
    @Provides
    fun provideTurnoDao(database: AppDatabaseRoom): TurnoDao {
        return database.turnoDao()
    }

}