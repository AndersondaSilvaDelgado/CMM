package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_EQUIP
import br.com.usinasantafe.cmm.features.infra.models.stable.EquipModel

@Dao
interface EquipDao {

    @Insert
    suspend fun insertAll(vararg equipModels: EquipModel)

    @Query("DELETE FROM $TB_EQUIP")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_EQUIP WHERE nroEquip = :nroEquip")
    suspend fun getNro(nroEquip: Long): EquipModel

    @Query("SELECT * FROM $TB_EQUIP WHERE idEquip = :idEquip")
    suspend fun getId(idEquip: Long): EquipModel

}