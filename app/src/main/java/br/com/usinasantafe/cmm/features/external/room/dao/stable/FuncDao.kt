package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_FUNC
import br.com.usinasantafe.cmm.features.infra.models.stable.FuncModel

@Dao
interface FuncDao {

    @Insert
    suspend fun insertAll(vararg funcModels: FuncModel)

    @Query("DELETE FROM $TB_FUNC")
    suspend fun deleteAll()

    @Query("SELECT count(*) FROM $TB_FUNC WHERE matricFunc = :nroMatric")
    suspend fun checkMatric(nroMatric : Long): Int

}