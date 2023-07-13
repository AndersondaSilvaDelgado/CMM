package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_PNEU
import br.com.usinasantafe.cmm.features.infra.models.room.stable.PneuRoomModel

@Dao
interface PneuDao {

    @Insert
    suspend fun insertAll(vararg pneuRoomModels: PneuRoomModel)

    @Query("DELETE FROM $TB_PNEU")
    suspend fun deleteAll()
}