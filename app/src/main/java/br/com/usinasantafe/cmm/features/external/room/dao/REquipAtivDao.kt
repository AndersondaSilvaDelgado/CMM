package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_ATIV
import br.com.usinasantafe.cmm.features.infra.models.stable.REquipAtivModel

@Dao
interface REquipAtivDao {

    @Insert
    suspend fun insertAll(vararg rEquipAtivModels: REquipAtivModel)

    @Query("DELETE FROM $TB_R_EQUIP_ATIV")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_R_EQUIP_ATIV WHERE idEquip = :idEquip")
    suspend fun listIdEquip(idEquip: Long): List<REquipAtivModel>

}