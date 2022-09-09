package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.PressaoBocalModel

@Dao
interface PressaoBocalDao {

    @Insert
    suspend fun insert(pressaoBocalModel: PressaoBocalModel): Long

    @Query("DELETE FROM tbpressaobocalest")
    suspend fun deleteAll()

}