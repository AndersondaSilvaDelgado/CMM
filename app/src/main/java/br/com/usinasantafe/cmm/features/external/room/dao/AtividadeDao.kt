package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.AtividadeModel

@Dao
interface AtividadeDao {

    @Insert
    fun insertAll(vararg atividadeModels: AtividadeModel)

    @Query("DELETE FROM tbatividadeest")
    suspend fun deleteAll()

    @Query("SELECT * FROM tbatividadeest WHERE idAtiv IN (:idAtivs)")
    suspend fun listInIdAtiv(vararg idAtivs: Long): List<AtividadeModel>

}