package br.com.usinasantafe.cmm.features.external.room

import androidx.room.*
import br.com.usinasantafe.cmm.common.utils.VERSION_DB
import br.com.usinasantafe.cmm.features.external.room.dao.stable.*
import br.com.usinasantafe.cmm.features.external.room.dao.variable.ApontFertDao
import br.com.usinasantafe.cmm.features.external.room.dao.variable.ApontMMDao
import br.com.usinasantafe.cmm.features.external.room.dao.variable.BoletimFertDao
import br.com.usinasantafe.cmm.features.external.room.dao.variable.BoletimMMDao
import br.com.usinasantafe.cmm.features.infra.models.stable.*
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontFertRoomModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontMMRoomModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimFertRoomModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMRoomModel

@Database(
    entities = [
        ApontFertRoomModel::class,
        ApontMMRoomModel::class,
        AtividadeModel::class,
        BocalModel::class,
        ComponenteModel::class,
        BoletimMMRoomModel::class,
        BoletimFertRoomModel::class,
        EquipModel::class,
        EquipSegModel::class,
        FrenteModel::class,
        FuncModel::class,
        ItemCheckListModel::class,
        ItemOSMecanModel::class,
        LeiraModel::class,
        OperMotoMecModel::class,
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
        TurnoModel::class], version = VERSION_DB, exportSchema = false
)
abstract class AppDatabaseRoom : RoomDatabase() {
    abstract fun apontFertDao(): ApontFertDao
    abstract fun apontMMDao(): ApontMMDao
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
    abstract fun motoMecDao(): OperMotoMecDao
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


