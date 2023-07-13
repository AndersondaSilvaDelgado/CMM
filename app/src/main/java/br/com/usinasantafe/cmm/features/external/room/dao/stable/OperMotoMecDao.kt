package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_OPER_MOTOMEC
import br.com.usinasantafe.cmm.features.infra.models.room.stable.OperMotoMecRoomModel

@Dao
interface OperMotoMecDao {

    @Insert
    suspend fun insertAll(vararg operMotoMecRoomModels: OperMotoMecRoomModel)

    @Query("DELETE FROM $TB_OPER_MOTOMEC")
    suspend fun deleteAll()

}