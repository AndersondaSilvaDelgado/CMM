package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.usinasantafe.cmm.common.utils.TB_APONT_MM
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_MM
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMRoomModel

@Dao
interface BoletimMMDao {

    @Insert
    suspend fun insert(boletimMMRoomModel: BoletimMMRoomModel): Long

    @Update
    suspend fun update(boletimMMRoomModel: BoletimMMRoomModel): Int

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE statusBolMM = :status")
    suspend fun listBoletimStatus(status: Long): List<BoletimMMRoomModel>

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE statusEnvioBolMM = :statusEnvio")
    suspend fun listBoletimStatusEnvio(statusEnvio: Long): List<BoletimMMRoomModel>

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE idBolMM = :idBol")
    suspend fun listBoletimIdBol(idBol: Long): List<BoletimMMRoomModel>

}