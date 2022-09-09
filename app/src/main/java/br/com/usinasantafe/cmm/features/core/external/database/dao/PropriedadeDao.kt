package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.PropriedadeModel

@Dao
interface PropriedadeDao {

    @Insert
    suspend fun insert(propriedadeModel: PropriedadeModel): Long

    @Query("DELETE FROM tbpropriedadeest")
    suspend fun deleteAll()

}