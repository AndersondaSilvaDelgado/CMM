package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_ATIV
import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipAtivRoomModel

@Dao
interface REquipAtivDao {

    @Insert
    suspend fun insertAll(vararg rEquipAtivRoomModels: REquipAtivRoomModel)

    @Query("DELETE FROM $TB_R_EQUIP_ATIV")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_R_EQUIP_ATIV WHERE idEquip = :idEquip")
    suspend fun listIdEquip(idEquip: Long): List<REquipAtivRoomModel>

}