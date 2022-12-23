package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_LEIRA
import br.com.usinasantafe.cmm.features.infra.models.stable.LeiraModel

@Dao
interface LeiraDao {

    @Insert
    suspend fun insertAll(vararg leiraModels: LeiraModel)

    @Query("DELETE FROM $TB_LEIRA")
    suspend fun deleteAll()

}