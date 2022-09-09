package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.EquipModel

@Dao
interface EquipDao {

    @Insert
    suspend fun insert(equipModel: EquipModel): Long

    @Query("DELETE FROM tbequipest")
    suspend fun deleteAll()

}