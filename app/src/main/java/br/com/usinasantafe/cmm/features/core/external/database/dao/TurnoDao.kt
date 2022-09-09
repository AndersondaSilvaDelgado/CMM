package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.TurnoModel

@Dao
interface TurnoDao {

    @Insert
    suspend fun insert(turnoModel: TurnoModel): Long

    @Query("DELETE FROM tbturnoest")
    suspend fun deleteAll()

}