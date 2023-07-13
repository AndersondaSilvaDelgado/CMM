package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_PARADA
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ParadaRoomModel

@Dao
interface ParadaDao {

    @Insert
    suspend fun insertAll(vararg paradaRoomModels: ParadaRoomModel)

    @Query("DELETE FROM $TB_PARADA")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_PARADA WHERE idParada IN (:idParadas)")
    suspend fun listInIdParada(vararg idParadas: Long): List<ParadaRoomModel>

}