package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.common.utils.TB_CABEC_CHECK_LIST
import br.com.usinasantafe.cmm.features.infra.models.room.variable.CabecCheckListRoomModel

@Dao
interface CabecCheckListDao {

    @Insert
    suspend fun insert(cabecCheckListRoomModel: CabecCheckListRoomModel): Long

    @Update
    suspend fun update(cabecCheckListRoomModel: CabecCheckListRoomModel): Int

    @Query("SELECT * FROM $TB_CABEC_CHECK_LIST WHERE statusData = :status")
    suspend fun listCabecStatusData(status: StatusData): List<CabecCheckListRoomModel>

    @Query("SELECT * FROM $TB_CABEC_CHECK_LIST WHERE statusSend = :status")
    suspend fun listCabecStatusSend(status: StatusSend): List<CabecCheckListRoomModel>

    @Query("SELECT * FROM $TB_CABEC_CHECK_LIST WHERE idCabecCheckList = :idCabec")
    suspend fun listCabecIdCabec(idCabec: Long): List<CabecCheckListRoomModel>

}