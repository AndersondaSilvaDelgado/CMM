package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.PneuModel

@Dao
interface PneuDao {

    @Insert
    suspend fun insert(pneuModel: PneuModel): Long

    @Query("DELETE FROM tbpneuest")
    suspend fun deleteAll()
}