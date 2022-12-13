package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_PRESSAO_BOCAL
import br.com.usinasantafe.cmm.features.infra.models.stable.PressaoBocalModel

@Dao
interface PressaoBocalDao {

    @Insert
    suspend fun insertAll(vararg pressaoBocalModels: PressaoBocalModel)

    @Query("DELETE FROM $TB_PRESSAO_BOCAL")
    suspend fun deleteAll()

}