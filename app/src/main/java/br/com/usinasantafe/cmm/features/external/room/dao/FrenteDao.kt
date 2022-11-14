package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.FrenteModel

@Dao
interface FrenteDao {

    @Insert
    suspend fun insert(frenteModel: FrenteModel): Long

    @Query("DELETE FROM tbfrenteest")
    suspend fun deleteAll()

}