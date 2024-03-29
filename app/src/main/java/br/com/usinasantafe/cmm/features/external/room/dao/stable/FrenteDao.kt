package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_FRENTE
import br.com.usinasantafe.cmm.features.infra.models.room.stable.FrenteRoomModel

@Dao
interface FrenteDao {

    @Insert
    suspend fun insertAll(vararg frenteRoomModels: FrenteRoomModel)

    @Query("DELETE FROM $TB_FRENTE")
    suspend fun deleteAll()

}