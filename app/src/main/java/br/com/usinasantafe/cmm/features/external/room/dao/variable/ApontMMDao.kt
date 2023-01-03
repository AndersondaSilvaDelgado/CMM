package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.usinasantafe.cmm.common.utils.TB_APONT_MM
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontMMRoomModel

@Dao
interface ApontMMDao {

    @Insert
    suspend fun insert(apontMMRoomModel: ApontMMRoomModel): Long

    @Query("SELECT * FROM $TB_APONT_MM WHERE idBolApontMM = :idBol and statusApontMM = :status")
    suspend fun listApontIdBolStatusEnvio(status: Long, idBol: Long): List<ApontMMRoomModel>

    @Query("SELECT * FROM $TB_APONT_MM WHERE statusApontMM = :status")
    suspend fun listApontStatusEnvio(status: Long): List<ApontMMRoomModel>

    @Query("UPDATE $TB_APONT_MM SET statusApontMM = :status WHERE idBolApontMM = :idApont")
    suspend fun updateIdApontEnviado(status: Long, idApont: Long): Int

}