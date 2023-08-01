package br.com.usinasantafe.cmm.features.external.room

import androidx.room.*
import br.com.usinasantafe.cmm.common.utils.VERSION_DB
import br.com.usinasantafe.cmm.features.external.room.dao.stable.*
import br.com.usinasantafe.cmm.features.external.room.dao.variable.*
import br.com.usinasantafe.cmm.features.infra.models.room.stable.*
import br.com.usinasantafe.cmm.features.infra.models.room.variable.*

@Database(
    entities = [
        ApontFertRoomModel::class,
        ApontMMRoomModel::class,
        AtividadeRoomModel::class,
        BocalRoomModel::class,
        CabecCheckListRoomModel::class,
        ComponenteRoomModel::class,
        BoletimMMRoomModel::class,
        BoletimFertRoomModel::class,
        EquipRoomModel::class,
        EquipSegRoomModel::class,
        FrenteRoomModel::class,
        FuncRoomModel::class,
        ItemCheckListRoomModel::class,
        ItemOSMecanRoomModel::class,
        LeiraRoomModel::class,
        OperMotoMecRoomModel::class,
        OSRoomModel::class,
        ParadaRoomModel::class,
        PneuRoomModel::class,
        PressaoBocalRoomModel::class,
        ProdutoRoomModel::class,
        PropriedadeRoomModel::class,
        RAtivParadaRoomModel::class,
        REquipAtivRoomModel::class,
        REquipPneuRoomModel::class,
        RespItemCheckListRoomModel::class,
        RFuncaoAtivParadaRoomModel::class,
        ROSAtivRoomModel::class,
        ServicoRoomModel::class,
        TurnoRoomModel::class], version = VERSION_DB, exportSchema = false
)
abstract class AppDatabaseRoom : RoomDatabase() {
    abstract fun apontFertDao(): ApontFertDao
    abstract fun apontMMDao(): ApontMMDao
    abstract fun atividadeDao(): AtividadeDao
    abstract fun bocalDao(): BocalDao
    abstract fun boletimFertDao(): BoletimFertDao
    abstract fun boletimMMDao(): BoletimMMDao
    abstract fun cabecCheckListDao(): CabecCheckListDao
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
    abstract fun respItemCheckListDao(): RespItemCheckListDao
    abstract fun rFuncaoAtivParadaDao(): RFuncaoAtivParadaDao
    abstract fun rOSAtivDao(): ROSAtivDao
    abstract fun servicoDao(): ServicoDao
    abstract fun turnoDao(): TurnoDao
}


