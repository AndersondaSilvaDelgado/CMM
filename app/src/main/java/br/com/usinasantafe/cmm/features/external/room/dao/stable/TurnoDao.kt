package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_TURNO
import br.com.usinasantafe.cmm.features.infra.models.room.stable.TurnoRoomModel

@Dao
interface TurnoDao {

    @Insert
    suspend fun insertAll(vararg turnoRoomModels: TurnoRoomModel)

    @Query("SELECT count(*) FROM $TB_TURNO")
    suspend fun count(): Int

    @Query("DELETE FROM $TB_TURNO")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_TURNO WHERE codTurno = :codTurno")
    suspend fun listCod(codTurno: Long): List<TurnoRoomModel>

}