package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.MotoMecModel

@Dao
interface MotoMecDao {

    @Insert
    suspend fun insert(motoMecModel: MotoMecModel): Long

    @Query("DELETE FROM tbmotomecest")
    suspend fun deleteAll()

}