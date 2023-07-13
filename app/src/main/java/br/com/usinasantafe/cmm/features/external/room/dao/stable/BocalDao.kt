package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_BOCAL
import br.com.usinasantafe.cmm.features.infra.models.room.stable.BocalRoomModel

@Dao
interface BocalDao {

    @Insert
    suspend fun insertAll(vararg bocalRoomModels: BocalRoomModel)

    @Query("DELETE FROM $TB_BOCAL")
    suspend fun deleteAll()

}