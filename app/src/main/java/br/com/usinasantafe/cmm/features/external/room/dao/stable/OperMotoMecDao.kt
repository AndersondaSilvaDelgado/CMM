package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_OPER_MOTOMEC
import br.com.usinasantafe.cmm.features.infra.models.stable.OperMotoMecModel

@Dao
interface OperMotoMecDao {

    @Insert
    suspend fun insertAll(vararg operMotoMecModels: OperMotoMecModel)

    @Query("DELETE FROM $TB_OPER_MOTOMEC")
    suspend fun deleteAll()

}