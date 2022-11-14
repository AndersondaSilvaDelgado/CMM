package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.OSModel

@Dao
interface OSDao {

    @Insert
    suspend fun insert(osModel: OSModel): Long

    @Query("DELETE FROM tbosest")
    suspend fun deleteAll()

}