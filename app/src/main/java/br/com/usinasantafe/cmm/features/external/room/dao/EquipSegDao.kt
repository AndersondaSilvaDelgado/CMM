package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.EquipSegModel

@Dao
interface EquipSegDao {

    @Insert
    suspend fun insert(equipSegModel: EquipSegModel): Long

    @Query("DELETE FROM tbequipsegest")
    suspend fun deleteAll()

}