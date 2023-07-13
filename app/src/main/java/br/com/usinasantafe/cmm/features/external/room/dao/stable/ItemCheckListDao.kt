package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_ITEM_CHECKLIST
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemCheckListRoomModel

@Dao
interface ItemCheckListDao {

    @Insert
    suspend fun insertAll(vararg itemCheckListRoomModels: ItemCheckListRoomModel)

    @Query("DELETE FROM $TB_ITEM_CHECKLIST")
    suspend fun deleteAll()

}