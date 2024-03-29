package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_EQUIP_SEG
import br.com.usinasantafe.cmm.features.infra.models.room.stable.EquipSegRoomModel

@Dao
interface EquipSegDao {

    @Insert
    suspend fun insertAll(vararg equipSegRoomModels: EquipSegRoomModel)

    @Query("SELECT count(*) FROM $TB_EQUIP_SEG WHERE nroEquip = :nroEquip and tipoEquip = :tipoEquip")
    suspend fun checkNroEquipTipo(nroEquip: Long, tipoEquip: Long): Int

    @Query("DELETE FROM $TB_EQUIP_SEG")
    suspend fun deleteAll()

}