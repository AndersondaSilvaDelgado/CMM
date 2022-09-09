package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.OSModel

@Dao
interface OSDao {

    @Insert
    suspend fun insert(osModel: OSModel): Long

    @Query("DELETE FROM tbosest")
    suspend fun deleteAll()

}