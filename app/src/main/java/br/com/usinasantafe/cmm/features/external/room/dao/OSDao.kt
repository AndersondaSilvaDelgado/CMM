package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.OSModel

@Dao
interface OSDao {

    @Insert
    suspend fun insertAll(vararg osModels: OSModel)

    @Query("DELETE FROM tbosest")
    suspend fun deleteAll()

    @Query("SELECT count(*) FROM tbosest WHERE nroOS = :nroOS")
    suspend fun check(nroOS: Long): Int

    @Query("SELECT * FROM tbosest WHERE nroOS = :nroOS")
    suspend fun getNroOS(nroOS: Long): OSModel
}