package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_EQUIP
import br.com.usinasantafe.cmm.features.infra.models.room.stable.EquipRoomModel

@Dao
interface EquipDao {

    @Insert
    suspend fun insertAll(vararg equipRoomModels: EquipRoomModel)

    @Query("SELECT count(*) FROM $TB_EQUIP")
    suspend fun count(): Int

    @Query("DELETE FROM $TB_EQUIP")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_EQUIP")
    suspend fun get(): EquipRoomModel

}