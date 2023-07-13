package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_R_OS_ATIV
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ROSAtivRoomModel

@Dao
interface ROSAtivDao {

    @Insert
    suspend fun insertAll(vararg rOSAtivRoomModels: ROSAtivRoomModel)

    @Query("DELETE FROM $TB_R_OS_ATIV")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_R_OS_ATIV WHERE idOS = :idOS")
    suspend fun listIdOS(idOS: Long): List<ROSAtivRoomModel>

}