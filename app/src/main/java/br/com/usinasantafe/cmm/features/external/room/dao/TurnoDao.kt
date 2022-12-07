package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.TurnoModel

@Dao
interface TurnoDao {

    @Insert
    suspend fun insertAll(vararg turnoModels: TurnoModel)

    @Query("DELETE FROM tbturnoest")
    suspend fun deleteAll()

    @Query("SELECT count(*) FROM tbturnoest")
    suspend fun count(): Int

    @Query("SELECT * FROM tbturnoest WHERE codTurno = :codTurno")
    suspend fun listCod(codTurno: Long): List<TurnoModel>

}