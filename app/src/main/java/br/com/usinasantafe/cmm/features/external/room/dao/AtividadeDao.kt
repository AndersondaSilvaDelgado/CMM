package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.AtividadeModel

@Dao
interface AtividadeDao {

    @Insert
    suspend fun insert(atividadeModel: AtividadeModel): Long

    @Query("DELETE FROM tbatividadeest")
    suspend fun deleteAll()

}