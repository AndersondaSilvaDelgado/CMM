package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_PARADA
import br.com.usinasantafe.cmm.features.infra.models.stable.ParadaModel

@Dao
interface ParadaDao {

    @Insert
    suspend fun insertAll(vararg paradaModels: ParadaModel)

    @Query("DELETE FROM $TB_PARADA")
    suspend fun deleteAll()

}