package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_R_ATIV_PARADA
import br.com.usinasantafe.cmm.features.infra.models.room.stable.RAtivParadaRoomModel

@Dao
interface RAtivParadaDao {

    @Insert
    suspend fun insertAll(vararg rAtivParadaRoomModels: RAtivParadaRoomModel)

    @Query("DELETE FROM $TB_R_ATIV_PARADA")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_R_ATIV_PARADA WHERE idAtiv = :idAtiv")
    suspend fun listIdAtiv(idAtiv: Long): List<RAtivParadaRoomModel>

}