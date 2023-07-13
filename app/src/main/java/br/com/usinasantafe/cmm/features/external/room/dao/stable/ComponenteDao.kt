package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_COMPONENTE
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ComponenteRoomModel

@Dao
interface ComponenteDao {

    @Insert
    suspend fun insertAll(vararg componenteRoomModels: ComponenteRoomModel)

    @Query("DELETE FROM $TB_COMPONENTE")
    suspend fun deleteAll()

}