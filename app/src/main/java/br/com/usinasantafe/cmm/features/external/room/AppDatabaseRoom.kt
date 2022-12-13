package br.com.usinasantafe.cmm.features.external.room

import androidx.room.*
import br.com.usinasantafe.cmm.common.utils.VERSION_DB
import br.com.usinasantafe.cmm.features.external.room.dao.*
import br.com.usinasantafe.cmm.features.infra.models.stable.*
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontFertModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontMMModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimFertModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMModel

@Database(entities = [AtividadeModel::class,
                            BocalModel::class,
                            ComponenteModel::class,
                            ApontFertModel::class,
                            ApontMMModel::class,
                            BoletimMMModel::class,
                            BoletimFertModel::class,
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
    , version = VERSION_DB
    , exportSchema = false)
abstract class AppDatabaseRoom: RoomDatabase() {
    abstract fun atividadeDao(): AtividadeDao
    abstract fun bocalDao(): BocalDao
    abstract fun boletimFertDao(): BoletimFertDao
    abstract fun boletimMMDao(): BoletimMMDao
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


