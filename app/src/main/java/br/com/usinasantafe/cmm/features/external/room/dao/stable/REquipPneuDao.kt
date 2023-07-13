package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_PNEU
import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipPneuRoomModel

@Dao
interface REquipPneuDao {

    @Insert
    suspend fun insertAll(vararg rEquipPneuRoomModels: REquipPneuRoomModel)

    @Query("DELETE FROM $TB_R_EQUIP_PNEU")
    suspend fun deleteAll()

}