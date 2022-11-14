package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.REquipAtivModel

@Dao
interface REquipAtivDao {

    @Insert
    suspend fun insert(rEquipAtivModel: REquipAtivModel): Long

    @Query("DELETE FROM tbrequipativest")
    suspend fun deleteAll()

}