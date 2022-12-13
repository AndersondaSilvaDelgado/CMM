package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_MOTOMEC
import br.com.usinasantafe.cmm.features.infra.models.stable.MotoMecModel

@Dao
interface MotoMecDao {

    @Insert
    suspend fun insertAll(vararg motoMecModels: MotoMecModel)

    @Query("DELETE FROM $TB_MOTOMEC")
    suspend fun deleteAll()

}