package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_BOCAL
import br.com.usinasantafe.cmm.features.infra.models.stable.BocalModel

@Dao
interface BocalDao {

    @Insert
    suspend fun insertAll(vararg bocalModels: BocalModel)

    @Query("DELETE FROM $TB_BOCAL")
    suspend fun deleteAll()

}