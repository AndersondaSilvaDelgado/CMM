package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_ITEM_OS_MECAN
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemOSMecanRoomModel

@Dao
interface ItemOSMecanDao {

    @Insert
    suspend fun insertAll(vararg itemOSMecanRoomModels: ItemOSMecanRoomModel)

    @Query("DELETE FROM $TB_ITEM_OS_MECAN")
    suspend fun deleteAll()
}