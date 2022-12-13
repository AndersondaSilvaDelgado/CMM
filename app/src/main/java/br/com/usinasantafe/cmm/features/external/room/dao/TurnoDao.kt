package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_TURNO
import br.com.usinasantafe.cmm.features.infra.models.stable.TurnoModel

@Dao
interface TurnoDao {

    @Insert
    suspend fun insertAll(vararg turnoModels: TurnoModel)

    @Query("DELETE FROM $TB_TURNO")
    suspend fun deleteAll()

    @Query("SELECT count(*) FROM $TB_TURNO")
    suspend fun count(): Int

    @Query("SELECT * FROM $TB_TURNO WHERE codTurno = :codTurno")
    suspend fun listCod(codTurno: Long): List<TurnoModel>

}