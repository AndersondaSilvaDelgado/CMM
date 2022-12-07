package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.FuncModel

@Dao
interface FuncDao {

    @Insert
    suspend fun insertAll(vararg funcModels: FuncModel)

    @Query("DELETE FROM tbfuncest")
    suspend fun deleteAll()

    @Query("SELECT count(*) FROM tbfuncest WHERE matricFunc = :nroMatric")
    suspend fun checkMatric(nroMatric : Long): Int

}