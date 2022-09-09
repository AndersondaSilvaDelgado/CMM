package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.FuncModel

@Dao
interface FuncDao {

    @Insert
    suspend fun insert(funcModel: FuncModel): Long

    @Query("DELETE FROM tbfuncest")
    suspend fun deleteAll()

}