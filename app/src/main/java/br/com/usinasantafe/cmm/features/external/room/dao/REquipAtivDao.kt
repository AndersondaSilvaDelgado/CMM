package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.REquipAtivModel
import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel

@Dao
interface REquipAtivDao {

    @Insert
    suspend fun insertAll(vararg rEquipAtivModels: REquipAtivModel)

    @Query("DELETE FROM tbrequipativest")
    suspend fun deleteAll()

    @Query("SELECT * FROM tbrequipativest WHERE idEquip = :idEquip")
    suspend fun listIdEquip(idEquip: Long): List<REquipAtivModel>

}