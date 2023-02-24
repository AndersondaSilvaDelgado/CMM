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

    @Update
    suspend fun update(apontMMRoomModel: ApontMMRoomModel): Int

    @Query("SELECT * FROM $TB_APONT_MM WHERE idBolApontMM = :idBol and statusEnvioApontMM = :statusEnvio")
    suspend fun listApontIdBolStatusEnviar(statusEnvio: Long, idBol: Long): List<ApontMMRoomModel>

    @Query("SELECT * FROM $TB_APONT_MM WHERE statusEnvioApontMM = :statusEnvio")
    suspend fun listApontStatusEnvio(statusEnvio: Long): List<ApontMMRoomModel>

    @Query("SELECT * FROM $TB_APONT_MM WHERE idApontMM = :idApont")
    suspend fun listApontIdApont(idApont: Long): List<ApontMMRoomModel>

}