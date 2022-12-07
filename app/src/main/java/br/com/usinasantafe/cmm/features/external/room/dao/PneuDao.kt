package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.PneuModel

@Dao
interface PneuDao {

    @Insert
    suspend fun insertAll(vararg pneuModels: PneuModel)

    @Query("DELETE FROM tbpneuest")
    suspend fun deleteAll()
}