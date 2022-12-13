package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_COMPONENTE
import br.com.usinasantafe.cmm.features.infra.models.stable.ComponenteModel

@Dao
interface ComponenteDao {

    @Insert
    suspend fun insertAll(vararg componenteModels: ComponenteModel)

    @Query("DELETE FROM $TB_COMPONENTE")
    suspend fun deleteAll()

}