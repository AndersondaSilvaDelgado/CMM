package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ItemOSMecanModel

@Dao
interface ItemOSMecanDao {

    @Insert
    suspend fun insertAll(vararg itemOSMecanModels: ItemOSMecanModel)

    @Query("DELETE FROM tbitemosmecanest")
    suspend fun deleteAll()
}