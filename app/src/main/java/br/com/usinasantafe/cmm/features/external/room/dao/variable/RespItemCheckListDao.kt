package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_RESP_ITEM_CHECK_LIST
import br.com.usinasantafe.cmm.features.infra.models.room.variable.RespItemCheckListRoomModel

@Dao
interface RespItemCheckListDao {

    @Insert
    suspend fun insert(respItemCheckListRoomModel: RespItemCheckListRoomModel): Long

    @Query("SELECT count(*) FROM $TB_RESP_ITEM_CHECK_LIST WHERE idCabecRespItemCheckList = :idCabec")
    suspend fun countRespItemCheckListIdCabec(idCabec: Long): Int

    @Query("DELETE FROM $TB_RESP_ITEM_CHECK_LIST WHERE idCabecRespItemCheckList = :idCabec AND idItemRespItemCheckList = :idItem")
    suspend fun deleteRespItemCheckListIdCabecIdItem(idCabec: Long, idItem: Long): Int

    @Query("SELECT * FROM $TB_RESP_ITEM_CHECK_LIST WHERE idCabecRespItemCheckList = :idCabec")
    suspend fun listRespItemCheckListIdCabec(idCabec: Long): List<RespItemCheckListRoomModel>

}