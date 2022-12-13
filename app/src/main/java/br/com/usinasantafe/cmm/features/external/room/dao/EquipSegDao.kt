package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_EQUIP_SEG
import br.com.usinasantafe.cmm.features.infra.models.stable.EquipSegModel

@Dao
interface EquipSegDao {

    @Insert
    suspend fun insertAll(vararg equipSegModels: EquipSegModel)

    @Query("DELETE FROM $TB_EQUIP_SEG")
    suspend fun deleteAll()

}