package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_APONT_MM
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontMMRoomModel

@Dao
interface ApontMMDao {

    @Insert
    suspend fun insert(apontMMRoomModel: ApontMMRoomModel): Long

    @Query("SELECT * FROM $TB_APONT_MM WHERE idBolApontMM = :idBol")
    suspend fun listApontIdBol(idBol: Long): List<ApontMMRoomModel>

}