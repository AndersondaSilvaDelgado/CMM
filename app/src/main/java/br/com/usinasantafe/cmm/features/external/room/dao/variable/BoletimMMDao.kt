package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_MM
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMRoomModel

@Dao
interface BoletimMMDao {

    @Insert
    suspend fun insert(boletimMMRoomModel: BoletimMMRoomModel): Long

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE statusBolMM = :status")
    suspend fun listBoletimStatus(status: Long): List<BoletimMMRoomModel>

}