package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.LeiraModel

@Dao
interface LeiraDao {

    @Insert
    suspend fun insert(leiraModel: LeiraModel): Long

    @Query("DELETE FROM tbleiraest")
    suspend fun deleteAll()

}