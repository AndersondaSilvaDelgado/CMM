package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.*
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_MM
import br.com.usinasantafe.cmm.features.infra.models.room.variable.BoletimMMRoomModel

@Dao
interface BoletimMMDao {

    @Insert
    suspend fun insert(boletimMMRoomModel: BoletimMMRoomModel): Long

    @Update
    suspend fun update(boletimMMRoomModel: BoletimMMRoomModel): Int

    @Delete
    suspend fun delete(boletimMMRoomModel: BoletimMMRoomModel): Int

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE statusBolMM = :status")
    suspend fun listBoletimFluxo(status: StatusData): List<BoletimMMRoomModel>

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE statusEnvioBolMM = :statusEnvio")
    suspend fun listBoletimStatusEnvio(statusEnvio: StatusSend): List<BoletimMMRoomModel>

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE statusEnvioBolMM = :statusEnvio and statusBolMM = :status")
    suspend fun listBoletimFluxoStatusEnvio(status: Long, statusEnvio: StatusSend): List<BoletimMMRoomModel>

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE idBolMM = :idBol")
    suspend fun listBoletimIdBol(idBol: Long): List<BoletimMMRoomModel>

}