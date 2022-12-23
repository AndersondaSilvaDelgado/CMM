package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_OS
import br.com.usinasantafe.cmm.features.infra.models.stable.OSModel

@Dao
interface OSDao {

    @Insert
    suspend fun insertAll(vararg osModels: OSModel)

    @Query("DELETE FROM $TB_OS")
    suspend fun deleteAll()

    @Query("SELECT count(*) FROM $TB_OS WHERE nroOS = :nroOS")
    suspend fun check(nroOS: Long): Int

    @Query("SELECT * FROM $TB_OS WHERE nroOS = :nroOS")
    suspend fun getNroOS(nroOS: Long): OSModel
}