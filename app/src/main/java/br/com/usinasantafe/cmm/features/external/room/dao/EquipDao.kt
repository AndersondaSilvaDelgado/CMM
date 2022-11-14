package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.EquipModel

@Dao
interface EquipDao {

    @Insert
    suspend fun insert(equipModel: EquipModel): Long

    @Query("DELETE FROM tbequipest")
    suspend fun deleteAll()

}