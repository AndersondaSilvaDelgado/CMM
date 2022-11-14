package br.com.usinasantafe.cmm.features.external.room

import androidx.room.*
import br.com.usinasantafe.cmm.features.external.room.dao.*
import br.com.usinasantafe.cmm.features.infra.models.*

@Database(entities = [AtividadeModel::class,
                            BocalModel::class,
                            ComponenteModel::class,
                            EquipModel::class,
                            EquipSegModel::class,
                            FrenteModel::class,
                            FuncModel::class,
                            ItemCheckListModel::class,
                            ItemOSMecanModel::class,
                            LeiraModel::class,
                            MotoMecModel::class,
                            OSModel::class,
                            ParadaModel::class,
                            PneuModel::class,
                            PressaoBocalModel::class,
                            ProdutoModel::class,
                            PropriedadeModel::class,
                            RAtivParadaModel::class,
                            REquipAtivModel::class,
                            REquipPneuModel::class,
                            RFuncaoAtivParadaModel::class,
                            ROSAtivModel::class,
                            ServicoModel::class,
                            TurnoModel::class]
    , version = 1
    , exportSchema = true)
abstract class AppDatabaseRoom: RoomDatabase() {

    abstract fun atividadeDao(): AtividadeDao
    abstract fun bocalDao(): BocalDao
    abstract fun componenteDao(): ComponenteDao
    abstract fun equipDao(): EquipDao
    abstract fun equipSegDao(): EquipSegDao
    abstract fun frenteDao(): FrenteDao
    abstract fun funcDao(): FuncDao
    abstract fun itemCheckListDao(): ItemCheckListDao
    abstract fun itemOSMecanDao(): ItemOSMecanDao
    abstract fun leiraDao(): LeiraDao
    abstract fun motoMecDao(): MotoMecDao
    abstract fun osDao(): OSDao
    abstract fun paradaDao(): ParadaDao
    abstract fun pneuDao(): PneuDao
    abstract fun pressaoBocalDao(): PressaoBocalDao
    abstract fun produtoDao(): ProdutoDao
    abstract fun propriedadeDao(): PropriedadeDao
    abstract fun rAtivParadaDao(): RAtivParadaDao
    abstract fun rEquipAtivDao(): REquipAtivDao
    abstract fun rEquipPneuDao(): REquipPneuDao
    abstract fun rFuncaoAtivParadaDao(): RFuncaoAtivParadaDao
    abstract fun rOSAtivDao(): ROSAtivDao
    abstract fun servicoDao(): ServicoDao
    abstract fun turnoDao(): TurnoDao
}


