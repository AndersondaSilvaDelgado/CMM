package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.ItemCheckListModel

@Dao
interface ItemCheckListDao {

    @Insert
    suspend fun insert(itemCheckListModel: ItemCheckListModel): Long

    @Query("DELETE FROM tbitemchecklistest")
    suspend fun deleteAll()

}