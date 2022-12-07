package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.EquipModel

@Dao
interface EquipDao {

    @Insert
    suspend fun insertAll(vararg equipModels: EquipModel)

    @Query("DELETE FROM tbequipest")
    suspend fun deleteAll()

    @Query("SELECT * FROM tbequipest WHERE nroEquip = :nroEquip")
    suspend fun getNro(nroEquip: Long): EquipModel

    @Query("SELECT * FROM tbequipest WHERE idEquip = :idEquip")
    suspend fun getId(idEquip: Long): EquipModel

}