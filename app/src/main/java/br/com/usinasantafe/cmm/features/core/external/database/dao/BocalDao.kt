package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.BocalModel

@Dao
interface BocalDao {

    @Insert
    suspend fun insert(bocalModel: BocalModel): Long

    @Query("DELETE FROM tbbocalest")
    suspend fun deleteAll()

}