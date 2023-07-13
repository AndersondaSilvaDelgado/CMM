package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_PRESSAO_BOCAL
import br.com.usinasantafe.cmm.features.infra.models.room.stable.PressaoBocalRoomModel

@Dao
interface PressaoBocalDao {

    @Insert
    suspend fun insertAll(vararg pressaoBocalRoomModels: PressaoBocalRoomModel)

    @Query("DELETE FROM $TB_PRESSAO_BOCAL")
    suspend fun deleteAll()

}